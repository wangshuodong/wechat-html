package com.wangsd.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoCplifeBillBatchqueryRequest;
import com.alipay.api.request.AlipayEcoCplifeBillDeleteRequest;
import com.alipay.api.request.AlipayEcoCplifeCommunityBatchqueryRequest;
import com.alipay.api.response.AlipayEcoCplifeBillBatchqueryResponse;
import com.alipay.api.response.AlipayEcoCplifeBillDeleteResponse;
import com.alipay.api.response.AlipayEcoCplifeCommunityBatchqueryResponse;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.web.pojo.alipay.AlipayBaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlipayUtil {

    private Logger log = LoggerFactory.getLogger(AlipayUtil.class);

    private AlipayBaseRequest baseRequest;

    private AlipayUtil() {

    }

    public AlipayUtil(AlipayBaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    /**
     * 物业费账单数据批量查询
     *
     * @return
     * @throws AlipayApiException
     */
    public JSONObject billBatchquery() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(StaticVar.alipay_serverUrl, baseRequest.getAppId(),
                baseRequest.getPrivateKey(), "json", "utf-8", baseRequest.getAlipayPulicKey(), "RSA2");
        AlipayEcoCplifeBillBatchqueryRequest request = new AlipayEcoCplifeBillBatchqueryRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeBillBatchqueryResponse response = alipayClient.execute(request);

        JSONObject ret = JSONObject.parseObject(response.getBody());
        log.debug("物业费账单数据批量查询=========>" + ret);

        return ret;
    }

    /**
     * 物业费账单数据批量删除
     *
     * @return
     * @throws AlipayApiException
     */
    public JSONObject billDelete() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(StaticVar.alipay_serverUrl, baseRequest.getAppId(),
                baseRequest.getPrivateKey(), "json", "utf-8", baseRequest.getAlipayPulicKey(), "RSA2");
        AlipayEcoCplifeBillDeleteRequest request = new AlipayEcoCplifeBillDeleteRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeBillDeleteResponse response = alipayClient.execute(request);

        JSONObject ret = JSONObject.parseObject(response.getBody());
        log.debug("物业费账单数据批量删除=========>" + ret);

        return ret;
    }

    /**
     * 批量查询支付宝小区编号
     * @return
     * @throws AlipayApiException
     */
    public JSONObject communityBatchquery() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(StaticVar.alipay_serverUrl, baseRequest.getAppId(),
                baseRequest.getPrivateKey(), "json", "utf-8", baseRequest.getAlipayPulicKey(), "RSA2");
        AlipayEcoCplifeCommunityBatchqueryRequest request = new AlipayEcoCplifeCommunityBatchqueryRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeCommunityBatchqueryResponse response = alipayClient.execute(request);

        JSONObject ret = JSONObject.parseObject(response.getBody());
        log.debug("批量查询支付宝小区编号=========>" + ret);
        return ret;
    }

    public AlipayBaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(AlipayBaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

}
