package com.wangsd.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoCplifeBillBatchqueryRequest;
import com.alipay.api.response.AlipayEcoCplifeBillBatchqueryResponse;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.web.pojo.alipay.AlipayRequest;
import com.wangsd.web.pojo.alipay.BillRequest;
import com.wangsd.web.pojo.alipay.BillResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class AlipayUtil {

    private static Logger log = LoggerFactory.getLogger(AlipayUtil.class);

    public static void main(String[] args) throws AlipayApiException {
        String appid = "2017071807800670";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJW2B/Wqka+T7s1HW/rFFKweF7fN+vtqmhkIvtXUoQi3+fiZKZjc1KHGLM8YS9BTUFNDcSvRva23qRlGp4ypbkl+QSx2spc0A2TKllVIBu9yWAvBIEVNBo3s8rRK1VWH8qKtMyYc2Q1rebeeEpFSJAjXGS99JS68GXo1QwDbH9kNAgMBAAECgYAHNHV5mzXbr1DkzDRfAzEVf3VAwUb85op3/fXBMLR3SPNcxXI9CxOonXL2nIK5iejpuOsvYq6wN5CJyN6zZEwMZpEXQ8ELhencbgYgBvBmvyPq5rnUb3MEt/W2B3EmgaCqYTfk0GWa50ybSh94ynBfK+DRy8NHYQg9kYzOfJt2gQJBAMUJ2wVR6PE2iK24jvcX/ajqE7kHRFf0T6bOKA4TRxxDMGNCH189RmXpxoPjrzsofKdh+qgvbLpz3e7cOG18Wp0CQQDCgqeSyxFecmmDvaDkn0Oj4GkgOdz6T23rsCfSVXWaBII0+nBlbWglQc/DwohTmdq8TBe6FnTfbOhDnIMo0DUxAkALXuQ6zF1K/kCo9cuaStIim0+ED/1LrheioqcBGO+zm9UBBWHWFy0m2HTSS6NjIJUA+9CBQCtgHyuhiyfeeZypAkBD4sfLgtYgCXxr/03dHPzFgDgQiEFolzo87PEpBqyRwYsUJGf/7kxP3IU/xHBCBUuDNmd9igLmS6NQnZplLy2xAkEAuIDbFGy34R8rEI5vXcqcMsn0tl5jBHSzbFcN1+3vz8dfudjl0RTqqpDXI1vtgbOph+NG3TVkSYbk0knjDNG15A==";

        AlipayRequest alipayRequest = new AlipayRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setApp_auth_token("201710BB47735a4ec11f45fd80838366df347X05");

        BillRequest billRequest = new BillRequest();
        billRequest.setCommunity_id("AWI1LRMIM3301");
        System.out.println(JSONObject.toJSONString(billRequest));
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));
        billBatchqueryRequest(alipayRequest);
    }

    /**
     * 物业费账单数据批量查询
     * @param alipayRequest
     * @return
     * @throws AlipayApiException
     */
    public static BillResponse billBatchqueryRequest(AlipayRequest alipayRequest) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(alipayRequest.getServerUrl(), alipayRequest.getAppId(), alipayRequest.getPrivateKey());
        AlipayEcoCplifeBillBatchqueryRequest request = new AlipayEcoCplifeBillBatchqueryRequest();
        request.putOtherTextParam("app_auth_token", alipayRequest.getApp_auth_token());
        request.setBizContent(alipayRequest.getBiz_content());
        AlipayEcoCplifeBillBatchqueryResponse response = alipayClient.execute(request);
        log.debug("物业费账单数据批量查询=========>" + JSONObject.toJSONString(response));

        BillResponse billResponse = new BillResponse();
        BeanUtils.copyProperties(response, billResponse);

        return billResponse;
    }
}
