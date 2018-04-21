package com.wangsd.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.wangsd.common.base.MyController;
import com.wangsd.common.utils.DateUtils;
import com.wangsd.common.utils.DecimalFormatUtils;
import com.wangsd.common.utils.yilianyun.Methods;
import com.wangsd.web.pojo.Report;
import com.wangsd.web.pojo.RoomCustom;
import com.wangsd.web.pojo.wechat.WeixinOauth2Token;
import com.wangsd.web.pojo.yunzhifu.OrderContent;
import com.wangsd.web.utils.WeixinUtil;
import com.wangsd.web.model.*;
import com.wangsd.web.pojo.BillaccountCustom;
import com.wangsd.web.service.*;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/wechat")
public class WechatController extends MyController {

    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

    @Autowired
    IWeixinconfigService weixinconfigService;
    @Autowired
    IPropertyinfoService propertyinfoService;
    @Autowired
    IHousinginfoService housinginfoService;
    @Autowired
    IRoominfoService roominfoService;
    @Autowired
    IWeixinuserService weixinuserService;
    @Autowired
    IBillaccountService billaccountService;
    @Autowired
    IPrintinfoService printinfoService;
    @Autowired
    INeworderService neworderService;

    /**
     * 公众号物业缴费入口
     *
     * @param code
     * @param state
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/index")
    public String index(String code, String state, Model model) throws IOException {
        String appId = state;
        String openid = getOpenId(appId, code);
        log.debug("用户openid:" + openid);

//      String openid = "oEa9Lwa4kghRxeDHTSGlxYlz1XcI";

        List<RoomCustom> roomlist = weixinuserService.queryRoomBunding(openid);

        model.addAttribute("list", JSONArray.fromObject(roomlist));
        return "wechat/myHousing";
    }

    /**
     * 打开新增房间页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/openHousing")
    public String openHousing(Model model) {
        String appId = (String) request.getSession().getAttribute("appId");
        List<Housinginfo> list = housinginfoService.queryHousingByAppId(appId);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Housinginfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getName());
                map.put("value", info.getId());
                retList.add(map);
            }
        }
        model.addAttribute("list", JSONArray.fromObject(retList));
        return "wechat/housing";
    }

    /**
     * 查询楼栋
     *
     * @param roominfo
     * @return
     */
    @RequestMapping("/queryBuilding")
    @ResponseBody
    public List<Map<String, String>> queryBuilding(Roominfo roominfo) {
        Example example = new Example(Roominfo.class);
        example.selectProperties("building");
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", roominfo.getParent_id()).andEqualTo("deleteStatus", false);
        List<Roominfo> list = roominfoService.selectByExample(example);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Roominfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getBuilding());
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 查询单元
     *
     * @param parent_id
     * @param building
     * @return
     */
    @RequestMapping("/queryUnit")
    @ResponseBody
    public List<Map<String, String>> queryUnit(Integer parent_id, String building) {
        Example example = new Example(Roominfo.class);
        example.selectProperties("unit");
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", parent_id).andEqualTo("building", building).andEqualTo("deleteStatus", false);
        List<Roominfo> list = roominfoService.selectByExample(example);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Roominfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getUnit());
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 查询房间
     *
     * @param parent_id
     * @param building
     * @param unit
     * @return
     */
    @RequestMapping("/queryRoom")
    @ResponseBody
    public List<Map<String, String>> queryRoom(Integer parent_id, String building, String unit) {
        Example example = new Example(Roominfo.class);
        example.selectProperties("id", "room");
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", parent_id)
                .andEqualTo("building", building)
                .andEqualTo("unit", unit)
                .andEqualTo("deleteStatus", false);
        List<Roominfo> list = roominfoService.selectByExample(example);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Roominfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getRoom());
                map.put("value", info.getId());
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 绑定房间
     *
     * @param weixinuser
     * @param model
     * @return
     */
    @RequestMapping("/bindingRoom")
    public String bindingRoom(Weixinuser weixinuser, Model model) {
        String openid = (String) request.getSession().getAttribute("openid");
        weixinuser.setOpenid(openid);
        weixinuserService.bingRoom(weixinuser);
        List<RoomCustom> roomlist = weixinuserService.queryRoomBunding(openid);

        model.addAttribute("list", JSONArray.fromObject(roomlist));
        return "wechat/myHousing";
    }

    /**
     * 打开账单页面
     *
     * @param roomid
     * @param model
     * @return
     */
    @RequestMapping("/openBill")
    public String openBill(Integer roomid, Model model) {

        Roominfo roominfo = roominfoService.selectByKey(roomid);
        Housinginfo housinginfo = housinginfoService.selectByKey(roominfo.getParent_id());

        List<BillaccountCustom> list = billaccountService.queryBillByRoomId(roomid);
        double sumAmount = 0;
        for (BillaccountCustom bill : list) {
            sumAmount += bill.getBill_entry_amount();
        }

        model.addAttribute("housinginfo", housinginfo);
        model.addAttribute("sumAmount", DecimalFormatUtils.format(sumAmount));
        model.addAttribute("list", list);
        return "wechat/billaccount";
    }

    /**
     * 删除绑定的房间
     *
     * @param id
     */
    @RequestMapping("/deleteBingRoom")
    @ResponseBody
    public String deleteBingRoom(Integer id) {
        weixinuserService.delete(id);
        return "success";
    }

    /**
     * 微信云支付付款
     */
    @RequestMapping("/yunzhifuPay")
    public void yunzhifuPay(String yunzhifu_order, String yunzhifu_amount, String shopId, String order_prefix) {
        System.out.println(shopId);
        yunzhifu_order = yunzhifu_order.substring(0, yunzhifu_order.length() - 1);
        yunzhifu_amount = yunzhifu_amount.substring(1, yunzhifu_amount.length());
        double temp = Double.parseDouble(yunzhifu_amount) * 100;
        int amount = (int)temp;
        String orderId = order_prefix + System.currentTimeMillis();
        String[] billids = yunzhifu_order.split(",");
        for (String id : billids) {
            Neworder neworder = new Neworder();
            neworder.setBillId(Integer.parseInt(id));
            neworder.setOrderId(orderId);
            neworder.setStatus(0);
            neworder.setCreateTime(new Date());
            neworderService.save(neworder);
        }
        String str = "https://pay.qcloud.com/cpay/qrcode_disposable_payment?out_shop_id=" + shopId + "&total_fee=" + amount + "&trade_num=" + orderId;
        try {
            response.sendRedirect(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 微信云支付交易完成回调
     */
    @RequestMapping("/whchatPayReturn")
    @ResponseBody
    public void whchatPayReturn(@RequestBody String outstr) {
        JSONObject obj = JSONObject.parseObject(outstr);
        JSONObject orderContent = obj.getJSONObject("request_content").getJSONObject("order_content");
        String out_trade_no = orderContent.getString("out_trade_no");
        String time_end = orderContent.getString("time_end");
        String transaction_id = orderContent.getString("transaction_id");

        boolean bl = neworderService.updateNeworderAndBillAccount(out_trade_no, time_end, transaction_id);
        if (bl) {
            Map<String, Object> responseContent = new HashMap<>();
            responseContent.put("status", 0);
            Map<String, Object> result = new HashMap<>();
            result.put("response_content", responseContent);
            try {
                response.getOutputStream().print(JSONObject.toJSONString(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 支付完成页
     */
    @RequestMapping("/whchatPaySuccess")
    public String whchatPaySuccess() {
        return "wechat/success";
    }

    /**
     * 打开报事报修页面
     *
     * @return
     */
    @RequestMapping("/openReport")
    public String openReport(String code, String state, Model model) {
        String appId = state;
        getOpenId(appId, code);
        List<Housinginfo> list = housinginfoService.queryHousingByAppId(appId);
        model.addAttribute("list", list);
        return "wechat/report";
    }

    /**
     * 推送报事报修信息到打印机
     *
     * @return
     */
    @RequestMapping("/sendReport")
    @ResponseBody
    public String sendReport(Report report) {
        Printinfo printinfo = new Printinfo();
        printinfo.setDepartment_id(report.getHousingId());
        printinfo = printinfoService.selectOne(printinfo);
        StringBuffer message = new StringBuffer();
        message.append("<FH2><FB><center>报事报修单据</center></FB></FH2>\n")
                .append("小区：" + report.getHousingName() + "\n")
                .append("业主姓名：" + report.getUsername() + "\n")
                .append("业主电话：" + report.getPhone() + "\n")
                .append("业主地址：" + report.getAddress() + "\n")
                .append("时间：" + DateUtils.getCurDatetime() + "\n")
                .append("事由：\n")
                .append("      " + report.getContent() + "\n");
        /*String str = "<FH2><FB><center>报事报修单据</center></FB></FH2>\n" +
                "业主姓名：张某某\n" +
                "业主电话：17784495560\n" +
                "业主地址：某某小区1栋8单元6-02\n" +
                "事由：\n" +
                "      更换手龙头更换手龙头更换手龙头更换手龙头更换手龙头更换手龙头\n";*/
        String originId = String.valueOf(System.currentTimeMillis());
        Methods.getInstance().print(printinfo.getMachine_code(), message.toString(), originId);

        return "提交成功";
    }

    public String getOpenId(String appId, String code) {
        Weixinconfig query = new Weixinconfig();
        query.setAppId(appId);
        Weixinconfig weixinconfig = weixinconfigService.selectOne(query);
        //获取网页授权access_token
        WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(weixinconfig.getAppId(), weixinconfig.getAppSecret(), code);

        // 网页授权接口访问凭证
        String access_token = weixinOauth2Token.getAccess_token();
        // 用户标识
        String openid = weixinOauth2Token.getOpenid();
        // 获取用户信息
        //WechatUserInfo snsUserInfo = WeixinUtil.getWechatUserInfo(access_token, openid);
        request.getSession().setAttribute("appId", appId);
        request.getSession().setAttribute("openid", openid);
        return openid;
    }
}
