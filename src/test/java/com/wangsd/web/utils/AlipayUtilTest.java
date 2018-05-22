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

    //威海威付
//    String appid = "2018050702645947";
//    String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTWs2ijGEQlNOfBsi8IzVpgpECqWQ8D0f4BcSOuPviTPFIj+un65ug09mbazX6ATr8uYvvPscnEtsJWLvHccB7Ebd/VvzYBy1pYE83v1QgaUHMxHgzU1x97EFzptdfpxW+TGhExKfePX5wv0ixMcokRhZLYWW3+Jlft8mRweOqt3qhZPOQ54KQ/1Ou588bcljcBH69oTsnMh2s1Bybt37sKY3kaZ823U4tiNhIiWS5wD2EqC3aGWlolh8OY3iSKWkI/5xgSa+gHzQNPaiE7+oKxjdhHx+E/4P+qp1f5XqmLFTGUZ6rPOdtIt2ywt+pul7sWX+0p+SVAvoVDdbsQqMNAgMBAAECggEAH27TRsVjP0JAEkBEOb3Y+vTbMhIoS5eG5qV0VG2pbZC0N6Jbxqo/vIL0fG7WSMpSZu69pv9hRDiFeOzwwY7GXHpfBk7sCLkfOsdMnru1mmRZoPCYI3q41DO9kooYj1L5FGsAIwtAM+wyOKLVQtc4I5y/zLyuEhx5uy1dVjZh9lxycSsgkLHRNH/VUfbf4KLP6bwoGxLjWelR4r3bPAEnuGB+RZmYL8TVKgc0hRHS8Lsvf6Qi4oMfqIOyb6DBF10lUwrBNuQ7pc1gaenvGljnFbbOKO+PJdb5PQR8M4b1UrSAnc8SrdXp6xmUfSdy0SDK8gyxdxhrA3IgVJ6MyrwogQKBgQDFGqE1zevtx+r5EF8kHYWJ7KF/NFVQXxIj3pTa5476fRFylHxjtlbPelHMlm8cwJF6R94NWWWrR15UxRSi9Db38OGlVh3Iy0z+Mry5qfAPWMW15DhH3idcVJPTTwNcRXdCDcWhgDjZnWcdEmVNSmWYtnkOUELA3gG/np7YXwS71QKBgQC/Yp/2+KEos/cYTCB57M8iD51E/TFIq56NGvEjfd/vIKRmf8J/FaN73UCYLevXkJ6bfE1EWHPUxRWaUlUMHGeNSoKHdCJVQFRnYb+wAQPIjiY7B07aMJWEP9k9NfY/BAQL3dXjAIV8ncmtT/Dffc8rYu447BaUXzvB2NNRTED+WQKBgH7Z7pq0Fn0Hxv/YO4MAxOrJMf6t7aI2LXSMUXy4vloTl+EIEy4RMbmB3Zcv0f7NKFNsYUpyGG6tFda0p91gEuhrTK2dyLlrrfeDK9bJucgGt+eiI16NaQORIzpBhcYipugJ+QFBhlT3al9ZcXzWvqAT/8Dogq2hs7phGZXjQSapAoGAV7XIX/RUT4YiwRTqcVZRG2gSiHKNKqPUdxCY4M4oWbwY/AyjQ4DUOskMeHHbOyDBP7r44lCzTRjBrMb8yR8fagZyycc0kON5iyOmKPBeHoTfCoBv59kKPODSG5ZmczzQ6etRwcYUZycdLXuMhbBvyI9/Y8D3HCqFBXLsbb7HrokCgYAP4DhyDTyWPa3Nm/Dn3L8LO8t0L0UbVu2ZCmYU/6WsDq99Iq/4Y5j9r32ewF+3IA5oa6/wYnvzvdDKm8BvZCbdrlAgmDrVLA4e0szUYzV9RyN5tKiz+rI1JHbEggB2hQ7N7TN0ebNk4y6yUFmBfmIwvmaspToN8dq6ib4H2T0pKw==";

    @Test
    public void billBatchquery() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setApp_auth_token("201709BBdb06c71a5bd0432193e9a992ac3f7X20");

        BillQueryRequest billRequest = new BillQueryRequest();
        billRequest.setCommunity_id("AW09TS6823301");
        billRequest.setOut_room_id("38918");
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.billBatchquery();
    }

    @Test
    public void billDelete() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setApp_auth_token("201709BBdb06c71a5bd0432193e9a992ac3f7X20");

        BillDeleteRequest billRequest = new BillDeleteRequest();
        billRequest.setCommunity_id("AW09TS6823301");
        List<String> ids = new ArrayList<>();
        ids.add("225650");
        billRequest.setBill_entry_id_list(ids);
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.billDelete();
    }

    @Test
    public void communityBatchquery() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setApp_auth_token("201709BBdb06c71a5bd0432193e9a992ac3f7X20");

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.communityBatchquery();
    }

}