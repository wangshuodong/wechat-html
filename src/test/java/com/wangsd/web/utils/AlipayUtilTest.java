package com.wangsd.web.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wangsd.web.pojo.alipay.*;
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
    //String appid = "2018050702645947";
    //String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTWs2ijGEQlNOfBsi8IzVpgpECqWQ8D0f4BcSOuPviTPFIj+un65ug09mbazX6ATr8uYvvPscnEtsJWLvHccB7Ebd/VvzYBy1pYE83v1QgaUHMxHgzU1x97EFzptdfpxW+TGhExKfePX5wv0ixMcokRhZLYWW3+Jlft8mRweOqt3qhZPOQ54KQ/1Ou588bcljcBH69oTsnMh2s1Bybt37sKY3kaZ823U4tiNhIiWS5wD2EqC3aGWlolh8OY3iSKWkI/5xgSa+gHzQNPaiE7+oKxjdhHx+E/4P+qp1f5XqmLFTGUZ6rPOdtIt2ywt+pul7sWX+0p+SVAvoVDdbsQqMNAgMBAAECggEAH27TRsVjP0JAEkBEOb3Y+vTbMhIoS5eG5qV0VG2pbZC0N6Jbxqo/vIL0fG7WSMpSZu69pv9hRDiFeOzwwY7GXHpfBk7sCLkfOsdMnru1mmRZoPCYI3q41DO9kooYj1L5FGsAIwtAM+wyOKLVQtc4I5y/zLyuEhx5uy1dVjZh9lxycSsgkLHRNH/VUfbf4KLP6bwoGxLjWelR4r3bPAEnuGB+RZmYL8TVKgc0hRHS8Lsvf6Qi4oMfqIOyb6DBF10lUwrBNuQ7pc1gaenvGljnFbbOKO+PJdb5PQR8M4b1UrSAnc8SrdXp6xmUfSdy0SDK8gyxdxhrA3IgVJ6MyrwogQKBgQDFGqE1zevtx+r5EF8kHYWJ7KF/NFVQXxIj3pTa5476fRFylHxjtlbPelHMlm8cwJF6R94NWWWrR15UxRSi9Db38OGlVh3Iy0z+Mry5qfAPWMW15DhH3idcVJPTTwNcRXdCDcWhgDjZnWcdEmVNSmWYtnkOUELA3gG/np7YXwS71QKBgQC/Yp/2+KEos/cYTCB57M8iD51E/TFIq56NGvEjfd/vIKRmf8J/FaN73UCYLevXkJ6bfE1EWHPUxRWaUlUMHGeNSoKHdCJVQFRnYb+wAQPIjiY7B07aMJWEP9k9NfY/BAQL3dXjAIV8ncmtT/Dffc8rYu447BaUXzvB2NNRTED+WQKBgH7Z7pq0Fn0Hxv/YO4MAxOrJMf6t7aI2LXSMUXy4vloTl+EIEy4RMbmB3Zcv0f7NKFNsYUpyGG6tFda0p91gEuhrTK2dyLlrrfeDK9bJucgGt+eiI16NaQORIzpBhcYipugJ+QFBhlT3al9ZcXzWvqAT/8Dogq2hs7phGZXjQSapAoGAV7XIX/RUT4YiwRTqcVZRG2gSiHKNKqPUdxCY4M4oWbwY/AyjQ4DUOskMeHHbOyDBP7r44lCzTRjBrMb8yR8fagZyycc0kON5iyOmKPBeHoTfCoBv59kKPODSG5ZmczzQ6etRwcYUZycdLXuMhbBvyI9/Y8D3HCqFBXLsbb7HrokCgYAP4DhyDTyWPa3Nm/Dn3L8LO8t0L0UbVu2ZCmYU/6WsDq99Iq/4Y5j9r32ewF+3IA5oa6/wYnvzvdDKm8BvZCbdrlAgmDrVLA4e0szUYzV9RyN5tKiz+rI1JHbEggB2hQ7N7TN0ebNk4y6yUFmBfmIwvmaspToN8dq6ib4H2T0pKw==";
    //String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt3yano4JjndXL498YccsUh9+FyjOQtJ+qjLK1vxVpeWlCVukyRa5K9951PK0DCFg0PpYmjidcacfrdBq7rbZGAzesI8AdVeqzgjNF0yJIBpSxilvQKwPYPdfF1fFYLN0C25xfUoRIQN3QQG3VVXINhz1oYmZosoyFr++rW4CM6RlsHBLB+Jo2ej1JEos533oaQZhq9zK+DPmRByWhjewVhaHzRBUjiBL7SrLpgpmDzks/o9JUu5bGY5yX159RY3jHH2EzM/66A8j66Mja6l6CClN6Mo04ziOdcZC+CsFhvsBuV02bQ762OlPkOPHOG7CHF3+vg7dkfBqmO2C5or0zwIDAQAB";
    //重庆朝阳科技
    //String appid = "2017081108140619";
    //String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTpUW3LULOJcZJ37cki1QVj78+kAk70KYIA9AWDNTdiTUUBSOr3J8Po3RdC3qqjt7dfJWyWtyDVu/0A3iRzDIpVjR8XoIbJhz3/6Q6xahKYoQ67dP0eqJtg+NtBgk/T5dr6c6Gp4+Lzj+DGk+Hrpft1ekqGd5cfNTGwdhxNz6NqCVZHevqB+mAFOiRh2vgr0ZtNOcdZOxrnxOoIAyL6IbJW7kRJuPO3/x8sVKf5GyknswJVqI7jKIPb2U2sydax1Uwpq7N+Hhqy7HrN/jQfBIluRmjDPk9aCTubcP9OR+Fut0188hyOzru0SjqrXmOtIyMC2m37kPPuoo+CxINTJDRAgMBAAECggEAKogeqCDqsLXjBB7lBCr6wudQ4TXe4xM88OwgQmnZ3CONXcIJP5XjYD7m43LOGFnly4n7GZDhGxitMO7bCaz3+j5yCi2zbxywlaRX6/JKg3sTumIOf8vgBIpMtnhZq5pC9Xw52UJlsJFubFbk+CIMdB/99fnTu3LeXI80yZBvfaCz9VJMdAc/pRhpz7WdTtxs8Fn9v9h+U18BZGhB9WnBBPLRvvHwseZWfphCqKFtum8t7IvrkvnxDN64X+Q8us7kTzbe0QQQgG9RIxTndDHIFgMuX10+ftDJ93lFtcnX6MkIdnJ9VXeYP4e9KKcTAnEgt5Ln/5wVEtArXIYoK2DNXQKBgQDlBDmZKWqMpbxX7hahAjsk+yRmBzU0C0Yt/8oDE6TCTKjgR5GUSWAG/ifuWfvRSssNPSgpwbuK20tzqAQzdZvfwFVThraqSzZIFuEfKqOpcpCAap6cyX9x/s++6C6mC7yhg7Ry4CDzkpILSS0Sc/bIlu+O5PPuloKrBreLfC/U/wKBgQClCqyfJS4Uc4F9jsvjeVcMDQQYbrd0MsR43Bl5D1Bb45SxhVANAvvn6+3Jazz8cVB6sHCWdWApihZJCddJELBmWFBoLOzRP7ypdhivBvx9Cu3Z6HIUGHhDFtfdT00IAtr5Rc7znRLdgkvTYmPWGZY448VHm/2lVm/U9JArmU2KLwKBgBgCrGNBc1lRmwCBBsBUsoy7A+LqiIpvUClMcwqFibWRQfdZqYqpcrbo+JjFuGAF/mnh6o8OL7JsMWnryJz4jKIV0RxTuFz8S7GdLHcPCl+ekkXUZ9K6UXFLLM6wGwvvmRQ58bZFh07iJAuo3V/c5pe7M1yA5o4yG3sA1kd6eq1TAoGAUPDMOfyU/cisD/TRP41JyIo1oPnjlOQ1AQUIpRuCkJ4rVWiJGuiEvHgzlR23uiKkkpcnkFKeR6EGTum5oIbDzF2xiXXG6tR0ZTOa5XPqrjSG8+CQ2hQqHtT8Jvh2UeB8ndXDqiw1jVcScugFCIJh7yKdpQH2wniCvhD3B7rWkVcCgYBDSb7vO3bRFYm/2x0jRE3O1NZzR3SUqZB8hGAERDGfmR4qFeFpCiRFGALE8852X9sbbf2lX6k5/XNuAoDSBqGpa9Q6pqv/DP8s0VgBvV5/IjK4gOxzGKJGGhiSPOqsf7qsFYufHthBVfXVG4VZV68mcH+9rJBhwvDnHsEKmK2lug==";
    //String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArFGhBurd9+JaAoubLfR9/O1kF4AQ3WLxgc/PtbnBkgZo5uRU0ncps9f3p6Z1hGQSHjNMSab1fw85wkfLh3lgJkEuTYFppQzyFSRIE50jx1BO3k/kFDl0AT9v1SYerqBMi7OFBWORM/nW+2/Qb0ed5lneKYmGOOeAJwimls6NIPpoVYQlJCCsyTRRWsp7Xl8yWRYdSri5INb2tEQrFf0hm3IlaTIIj6RVPNktIkUIHeQt7zh5HLJsLbol/USGXbQfSq+GzoGFsYtwZzx0h9z+OtjIm/sDUXha6zyDjPd/ES63Ahiy8ATZbUqE6E12T4OVeXJa1OLZ4YX4MjOlf5u8BQIDAQAB";


    @Test
    public void billDeleteByQuery() throws Exception  {
        /*boolean flag  = true;
        while (flag) {
            JSONObject obj = this.billBatchquery();

            //删除账单
            JSONArray array = obj.getJSONArray("bill_result_set");

            if (array.size() > 0) {
                List<String> ids = new ArrayList<>();
                for (int i=0; i<array.size(); i++) {
                    JSONObject item = (JSONObject)array.get(i);
                    ids.add(item.getString("bill_entry_id"));
                }
                this.billDelete(ids);
            }else {
                System.out.println("已经全部删除");
                flag = false;
            }
        }*/
        //查询账单

    }

    @Test
    public void billBatchquery() throws Exception {
        //支付宝公共请求参数
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201805BB167d6f075f1d4165a88e7c874e0c8X57");

        //账单查询请求参数
        BillQueryRequest request = new BillQueryRequest();
        request.setCommunity_id("AYQXETSB53710");
        //request.setOut_room_id("54746");
        //request.setBill_status("WAIT_PAYMENT");
        alipayRequest.setBiz_content(JSONObject.toJSONString(request));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        JSONObject obj = alipayUtil.billBatchquery();
        //return obj;
    }

    public void billDelete(List<String> ids) throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201807BB8d6d859fab9a42de871b0ae3b15daX68");

        BillDeleteRequest request = new BillDeleteRequest();
        request.setCommunity_id("AUAOM1SPX5001");
        request.setBill_entry_id_list(ids);
        alipayRequest.setBiz_content(JSONObject.toJSONString(request));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.billDelete();
    }


    /**
     * 批量查询支付宝小区编号
     * @throws Exception
     */
    @Test
    public void queryCommunity() throws Exception {
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201805BB167d6f075f1d4165a88e7c874e0c8X57");

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.queryCommunity();
    }


    /**
     * 查询小区房屋信息列表
     * @throws Exception
     */
    @Test
    public void queryRoominfo() throws Exception {
        //全局条件
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201708BBe8b0998c01ce4395a73896a11f243X23");

        //查询条件
        RoominfoQueryRequest request = new RoominfoQueryRequest();
        request.setCommunity_id("AFFK7LKRO3301");
        request.setPage_size(500);
        request.setPage_num(2);
        alipayRequest.setBiz_content(JSONObject.toJSONString(request));

        //执行
        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.queryRoominfo();
    }


    /**
     * 删除小区房屋信息列表
     * @throws Exception
     */
    @Test
    public void deleteRoominfo() throws Exception {
        //全局条件
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId(appid);
        alipayRequest.setPrivateKey(privateKey);
        alipayRequest.setAlipayPulicKey(publicKey);
        alipayRequest.setApp_auth_token("201807BB8d6d859fab9a42de871b0ae3b15daX68");

        //查询条件
        RoominfoDeleteRequest request = new RoominfoDeleteRequest();
        request.setCommunity_id("AZLAPQ55H5001");
        List<String> ids = new ArrayList<String>();
        ids.add("all");
        request.setOut_room_id_set(ids);
        request.setBatch_id(String.valueOf(System.currentTimeMillis()));
        alipayRequest.setBiz_content(JSONObject.toJSONString(request));

        //执行
        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        alipayUtil.deleteRoominfo();
    }

}
