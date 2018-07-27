package com.wangsd.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.web.pojo.alipay.AlipayBaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AlipayUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AlipayBaseRequest baseRequest;

    public void setBaseRequest(AlipayBaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    private AlipayClient alipayClient;


    private AlipayUtil() {

    }

    public AlipayUtil(AlipayBaseRequest baseRequest) {
        this.baseRequest = baseRequest;
        this.alipayClient = new DefaultAlipayClient(StaticVar.alipay_serverUrl, baseRequest.getAppId(),
                baseRequest.getPrivateKey(), "json", "utf-8", baseRequest.getAlipayPulicKey(), "RSA2");
    }


    /**
     * 物业费账单数据批量查询
     *
     * @return
     * @throws AlipayApiException
     */
    public JSONObject billBatchquery() throws AlipayApiException {
        AlipayEcoCplifeBillBatchqueryRequest request = new AlipayEcoCplifeBillBatchqueryRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeBillBatchqueryResponse response = alipayClient.execute(request);

        JSONObject json = JSONObject.parseObject(response.getBody()).getJSONObject("alipay_eco_cplife_bill_batchquery_response");
        logger.debug("物业费账单数据批量查询=========>" + json);

        return json;
    }

    /**
     * 物业费账单数据批量删除
     *
     * @return
     * @throws AlipayApiException
     */
    public JSONObject billDelete() throws AlipayApiException {
        AlipayEcoCplifeBillDeleteRequest request = new AlipayEcoCplifeBillDeleteRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeBillDeleteResponse response = alipayClient.execute(request);

        JSONObject json = JSONObject.parseObject(response.getBody()).getJSONObject("alipay_eco_cplife_bill_delete_response");
        logger.debug("物业费账单数据批量删除=========>" + json);

        return json;
    }

    public JSONObject createcCmmunity() {

        return null;
    }

    /**
     * 批量查询支付宝小区编号
     *
     * @return
     * @throws AlipayApiException
     */
    public JSONObject queryCommunity() throws AlipayApiException {
        AlipayEcoCplifeCommunityBatchqueryRequest request = new AlipayEcoCplifeCommunityBatchqueryRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeCommunityBatchqueryResponse response = alipayClient.execute(request);

        JSONObject json = JSONObject.parseObject(response.getBody());
        logger.debug("批量查询支付宝小区编号=========>" + json);
        return json;
    }

    /**
     * 查询小区房屋信息列表
     *
     * @return
     * @throws AlipayApiException
     */
    public JSONObject queryRoominfo() throws AlipayApiException {
        AlipayEcoCplifeRoominfoQueryRequest request = new AlipayEcoCplifeRoominfoQueryRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeRoominfoQueryResponse response = alipayClient.execute(request);

        JSONObject json = JSONObject.parseObject(response.getBody()).getJSONObject("alipay_eco_cplife_roominfo_query_response");
        logger.debug("查询小区房屋信息列表=========>" + json);
        return json;
    }


    /**
     * 删除小区房屋信息列表
     * 删除小区所有房间传all
     * @return
     * @throws AlipayApiException
     */
    public JSONObject deleteRoominfo() throws AlipayApiException {
        AlipayEcoCplifeRoominfoDeleteRequest request = new AlipayEcoCplifeRoominfoDeleteRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeRoominfoDeleteResponse response = alipayClient.execute(request);

        JSONObject json = JSONObject.parseObject(response.getBody()).getJSONObject("alipay_eco_cplife_roominfo_delete_response");
        logger.debug("删除小区房屋信息列表=========>" + json);
        return json;
    }

}
