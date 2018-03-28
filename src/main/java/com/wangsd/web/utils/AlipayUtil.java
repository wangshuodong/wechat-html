package com.wangsd.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoCplifeBillBatchqueryRequest;
import com.alipay.api.request.AlipayEcoCplifeBillDeleteRequest;
import com.alipay.api.response.AlipayEcoCplifeBillBatchqueryResponse;
import com.alipay.api.response.AlipayEcoCplifeBillDeleteResponse;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.web.pojo.alipay.AlipayBaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlipayUtil {

    private Logger log = LoggerFactory.getLogger(AlipayUtil.class);

    private AlipayBaseRequest baseRequest;

    private AlipayClient alipayClient;

    private AlipayUtil() {

    }

    public AlipayUtil(AlipayBaseRequest baseRequest) {
        this.baseRequest = baseRequest;
        alipayClient = new DefaultAlipayClient(StaticVar.alipay_serverUrl, baseRequest.getAppId(), baseRequest.getPrivateKey());
    }

    /**
     * 物业费账单数据批量查询
     * @return
     * @throws AlipayApiException
     */
    public Object billBatchquery() throws AlipayApiException {
        AlipayEcoCplifeBillBatchqueryRequest request = new AlipayEcoCplifeBillBatchqueryRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeBillBatchqueryResponse response = alipayClient.execute(request);

        log.debug("物业费账单数据批量查询=========>" + JSONObject.toJSON(response));

        return JSONObject.toJSON(response);
    }

    /**
     * 物业费账单数据批量删除
     * @return
     * @throws AlipayApiException
     */
    public Object billDelete() throws AlipayApiException {
        AlipayEcoCplifeBillDeleteRequest request = new AlipayEcoCplifeBillDeleteRequest();
        request.putOtherTextParam("app_auth_token", baseRequest.getApp_auth_token());
        request.setBizContent(baseRequest.getBiz_content());
        AlipayEcoCplifeBillDeleteResponse response = alipayClient.execute(request);

        log.debug("物业费账单数据批量删除=========>" + JSONObject.toJSON(response));

        return JSONObject.toJSON(response);
    }

}
