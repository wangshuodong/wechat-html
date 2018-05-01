package com.wangsd.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.wangsd.web.pojo.alipay.AlipayBaseRequest;
import com.wangsd.web.pojo.alipay.BillDeleteRequest;
import com.wangsd.web.pojo.alipay.BillQueryRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AlipayUtilTest {
    //早早科技
    String appid = "2017071807800670";
    String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJW2B/Wqka+T7s1HW/rFFKweF7fN+vtqmhkIvtXUoQi3+fiZKZjc1KHGLM8YS9BTUFNDcSvRva23qRlGp4ypbkl+QSx2spc0A2TKllVIBu9yWAvBIEVNBo3s8rRK1VWH8qKtMyYc2Q1rebeeEpFSJAjXGS99JS68GXo1QwDbH9kNAgMBAAECgYAHNHV5mzXbr1DkzDRfAzEVf3VAwUb85op3/fXBMLR3SPNcxXI9CxOonXL2nIK5iejpuOsvYq6wN5CJyN6zZEwMZpEXQ8ELhencbgYgBvBmvyPq5rnUb3MEt/W2B3EmgaCqYTfk0GWa50ybSh94ynBfK+DRy8NHYQg9kYzOfJt2gQJBAMUJ2wVR6PE2iK24jvcX/ajqE7kHRFf0T6bOKA4TRxxDMGNCH189RmXpxoPjrzsofKdh+qgvbLpz3e7cOG18Wp0CQQDCgqeSyxFecmmDvaDkn0Oj4GkgOdz6T23rsCfSVXWaBII0+nBlbWglQc/DwohTmdq8TBe6FnTfbOhDnIMo0DUxAkALXuQ6zF1K/kCo9cuaStIim0+ED/1LrheioqcBGO+zm9UBBWHWFy0m2HTSS6NjIJUA+9CBQCtgHyuhiyfeeZypAkBD4sfLgtYgCXxr/03dHPzFgDgQiEFolzo87PEpBqyRwYsUJGf/7kxP3IU/xHBCBUuDNmd9igLmS6NQnZplLy2xAkEAuIDbFGy34R8rEI5vXcqcMsn0tl5jBHSzbFcN1+3vz8dfudjl0RTqqpDXI1vtgbOph+NG3TVkSYbk0knjDNG15A==";


    @Test
    public void billBatchquery() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setApp_auth_token("201710BB47735a4ec11f45fd80838366df347X05");

        BillQueryRequest billRequest = new BillQueryRequest();
        billRequest.setCommunity_id("A46CQMCT73301");
        billRequest.setOut_room_id("119109");
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.billBatchquery();
    }

    @Test
    public void billDelete() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setApp_auth_token("201710BB47735a4ec11f45fd80838366df347X05");

        BillDeleteRequest billRequest = new BillDeleteRequest();
        billRequest.setCommunity_id("A46CQMCT73301");
        List<String> ids = new ArrayList<>();
        ids.add("140776");
        ids.add("177885");
        billRequest.setBill_entry_id_list(ids);
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.billDelete();
    }
}