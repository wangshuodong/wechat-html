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
    String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGqxZ5m7EpP3RPH5UtBKHU1A5hPPdkKEnJF6UoSsO5TDWARWjUlwcNkZ8CEHHBU1nUbmaS+OjGzd6sNFsOh9iyH78K/RGnBZEC7PeoDvqu3vedzQk/fDsbU8+cLx6CFcVMg4cTZarsbaP5C2GTCbWgs6iL4T86FLI00qFXxgrQZwWZR6/bL2yYPkeaAhYav4tD7JgYqzGjaJumXcEiSt4ymM+FCGWZxyr56kjvm95iiKjWk2XTOFGNoAmspU2Hf+Tg2pn8UwaQwmdmxh3ZuS7trNcZlqsOhlhAb0p7WFX4DgWtMeFq+ocHDz4/GJsGobYM63iQUPBnLY0AlhLuRIhlAgMBAAECggEADYy1TDMQFjheOX/SAJ+QsNtNPxdlRNyQ3/zTD0TGgKRcVbWmII25lfHq78g7ydnbFfatt2f389jO6MCz0Lh2YyWykSZ5WjbDKmoxWOV475NbkrMIlSyovc0m/G35Qdly6onpU1hNZFB7yRkODj9R2QN6l+hn9i4S6CGxPiWc/O7aSmJx/p2l4u3aBivkVi0LYaKgE1M3dvdSex08Czng9yhGDTZ2f3Wz4YgNX5XlqiS6DdCJN5ApgK2GLQNbjmxAe9EB+MNLx7L1KLXQXdSYEHedz3IDctiodXJLhY2TseFPoRg9WMVAMXTqTfsNA2p5btkyPzSc/pSgjTffAnOBGQKBgQDqtIfydJGbVGqFGDWurN+RmBEETosHYhe8S39VSWkQVwjAIXsWmHWz7a4KFx1QNZwPloyxjWf8EwdERduVpemzmVNzVJqjzih+vk/rdpPRKJ6x7k1qNtrtDCt6OxAqyNvqeWyPHN5Du1f8cUbe7zT4A4JJkYCrFHmWc/GInRd2jwKBgQCS4wMfRY2R4hSil+5Q1Nuk7snimj7OARJjffnc9cT9aialp4zancSQAINpfNKFKrwjwArHhnCN+Qr0qtMDhGskJ46w3+MR+CYG8/lMuSQM5hE9gkHDuId+2DmGzbX9ZONQc63HC8b4Qw3XjIsxeYMSTzDFEfV0pBdOc3gKRAirywKBgQDGyBQEAzp3Ri3Zf8GnqX7IvvRao3MY07mqnn6/6yby0eP1ZeXsI0A9HeazYRRQpLcCdM3AazVQx4T2C/yIaDbhB9En8tXuOmMNxX3GvW1ATpjpth0XAlK1RgNkyLVOp0Oq+SA6rYaJ8xf4FLCjjBFepQop6PQC8ZpxFM3SmMoQfQKBgGBAc+5NBHzg+galqlu7cAa/Fvnve1JAr40UouPhBOnOYm7QwWMMWR7Hx1Ubn1P18f03PZkLhrvxwvUa71Vxs0eoyD8tJr3CryCFRQq6k14EcK2uqmuXgupixCeKq0PVlYNFmk1BcWuDfRGPHjMYXgRkch/hKcf6Mu+MiM+pT0lLAoGAUcJzI84luxl4GjZQ4YT8QHN04Ox709GVW/TGYQhwPaTCVuj8Qb/GOZgKxb9Jflj2tB8PRqQEw8rlmGxC8eozltmamhr3FN9iuKHmaEFAgUnFKqfZxbPvTSPTkkaeQBJpE2nc0DqCTdt0XDjA5N73JIBfY7St9z4nvKdqjb4ZssI=";
    String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyN4dov3qQXKlN5kMm8yvbiNztIpcZ53/YdVhgwYroOnc0A7jJ8nZwHGK9bzkqp6pf2ZuWGeLirXnFoAaPbFORM6Zw0jtIT3OYzpHZGJpvk0nI7kX/10oxNI/x1XOZ3L8DmA1PsIinQOWAaflefJ0qjAnfsh6odBbMVkhv/j3PxibgY1qKfYsbFw3tzbEWg2fpVV9MJFEXOmDAnuQPOVHZIrD5PBZ+lHtmRp0NtGxL+5cDpCcv3HLIpWrTg2Tap1cVyVEDul3+wRK1LJ3cqAFsLb9weQBa1S/VpjWocOvBo79VtEmAPV9zyey+1mkV4Ok5RthRr8qGInylxnN8MIwawIDAQAB";
    //威海威付
//    String appid = "2018050702645947";
//    String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTWs2ijGEQlNOfBsi8IzVpgpECqWQ8D0f4BcSOuPviTPFIj+un65ug09mbazX6ATr8uYvvPscnEtsJWLvHccB7Ebd/VvzYBy1pYE83v1QgaUHMxHgzU1x97EFzptdfpxW+TGhExKfePX5wv0ixMcokRhZLYWW3+Jlft8mRweOqt3qhZPOQ54KQ/1Ou588bcljcBH69oTsnMh2s1Bybt37sKY3kaZ823U4tiNhIiWS5wD2EqC3aGWlolh8OY3iSKWkI/5xgSa+gHzQNPaiE7+oKxjdhHx+E/4P+qp1f5XqmLFTGUZ6rPOdtIt2ywt+pul7sWX+0p+SVAvoVDdbsQqMNAgMBAAECggEAH27TRsVjP0JAEkBEOb3Y+vTbMhIoS5eG5qV0VG2pbZC0N6Jbxqo/vIL0fG7WSMpSZu69pv9hRDiFeOzwwY7GXHpfBk7sCLkfOsdMnru1mmRZoPCYI3q41DO9kooYj1L5FGsAIwtAM+wyOKLVQtc4I5y/zLyuEhx5uy1dVjZh9lxycSsgkLHRNH/VUfbf4KLP6bwoGxLjWelR4r3bPAEnuGB+RZmYL8TVKgc0hRHS8Lsvf6Qi4oMfqIOyb6DBF10lUwrBNuQ7pc1gaenvGljnFbbOKO+PJdb5PQR8M4b1UrSAnc8SrdXp6xmUfSdy0SDK8gyxdxhrA3IgVJ6MyrwogQKBgQDFGqE1zevtx+r5EF8kHYWJ7KF/NFVQXxIj3pTa5476fRFylHxjtlbPelHMlm8cwJF6R94NWWWrR15UxRSi9Db38OGlVh3Iy0z+Mry5qfAPWMW15DhH3idcVJPTTwNcRXdCDcWhgDjZnWcdEmVNSmWYtnkOUELA3gG/np7YXwS71QKBgQC/Yp/2+KEos/cYTCB57M8iD51E/TFIq56NGvEjfd/vIKRmf8J/FaN73UCYLevXkJ6bfE1EWHPUxRWaUlUMHGeNSoKHdCJVQFRnYb+wAQPIjiY7B07aMJWEP9k9NfY/BAQL3dXjAIV8ncmtT/Dffc8rYu447BaUXzvB2NNRTED+WQKBgH7Z7pq0Fn0Hxv/YO4MAxOrJMf6t7aI2LXSMUXy4vloTl+EIEy4RMbmB3Zcv0f7NKFNsYUpyGG6tFda0p91gEuhrTK2dyLlrrfeDK9bJucgGt+eiI16NaQORIzpBhcYipugJ+QFBhlT3al9ZcXzWvqAT/8Dogq2hs7phGZXjQSapAoGAV7XIX/RUT4YiwRTqcVZRG2gSiHKNKqPUdxCY4M4oWbwY/AyjQ4DUOskMeHHbOyDBP7r44lCzTRjBrMb8yR8fagZyycc0kON5iyOmKPBeHoTfCoBv59kKPODSG5ZmczzQ6etRwcYUZycdLXuMhbBvyI9/Y8D3HCqFBXLsbb7HrokCgYAP4DhyDTyWPa3Nm/Dn3L8LO8t0L0UbVu2ZCmYU/6WsDq99Iq/4Y5j9r32ewF+3IA5oa6/wYnvzvdDKm8BvZCbdrlAgmDrVLA4e0szUYzV9RyN5tKiz+rI1JHbEggB2hQ7N7TN0ebNk4y6yUFmBfmIwvmaspToN8dq6ib4H2T0pKw==";
//    String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt3yano4JjndXL498YccsUh9+FyjOQtJ+qjLK1vxVpeWlCVukyRa5K9951PK0DCFg0PpYmjidcacfrdBq7rbZGAzesI8AdVeqzgjNF0yJIBpSxilvQKwPYPdfF1fFYLN0C25xfUoRIQN3QQG3VVXINhz1oYmZosoyFr++rW4CM6RlsHBLB+Jo2ej1JEos533oaQZhq9zK+DPmRByWhjewVhaHzRBUjiBL7SrLpgpmDzks/o9JUu5bGY5yX159RY3jHH2EzM/66A8j66Mja6l6CClN6Mo04ziOdcZC+CsFhvsBuV02bQ762OlPkOPHOG7CHF3+vg7dkfBqmO2C5or0zwIDAQAB";
    @Test
    public void billBatchquery() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201709BBdb06c71a5bd0432193e9a992ac3f7X20");

        BillQueryRequest billRequest = new BillQueryRequest();
        billRequest.setCommunity_id("AEJG4JY5A3301");
        billRequest.setOut_room_id("47227");
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.billBatchquery();
    }

    @Test
    public void billDelete() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201709BBdb06c71a5bd0432193e9a992ac3f7X20");

        BillDeleteRequest billRequest = new BillDeleteRequest();
        billRequest.setCommunity_id("AEJG4JY5A3301");
        List<String> ids = new ArrayList<>();
        ids.add("172431");
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
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201709BBdb06c71a5bd0432193e9a992ac3f7X20");

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.communityBatchquery();
    }

}