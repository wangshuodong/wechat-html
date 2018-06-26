package com.wangsd.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.wangsd.web.pojo.alipay.AlipayBaseRequest;
import com.wangsd.web.pojo.alipay.BillDeleteRequest;
import com.wangsd.web.pojo.alipay.BillQueryRequest;
import com.wangsd.web.utils.AlipayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @RequestMapping(value = "/queryAlipayBill", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject queryAlipayBill(String token, String communityId, String roomId, int pageNum, int pageSize) {
        //支付宝公共请求参数
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId("2017071807800670");
        alipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGqxZ5m7EpP3RPH5UtBKHU1A5hPPdkKEnJF6UoSsO5TDWARWjUlwcNkZ8CEHHBU1nUbmaS+OjGzd6sNFsOh9iyH78K/RGnBZEC7PeoDvqu3vedzQk/fDsbU8+cLx6CFcVMg4cTZarsbaP5C2GTCbWgs6iL4T86FLI00qFXxgrQZwWZR6/bL2yYPkeaAhYav4tD7JgYqzGjaJumXcEiSt4ymM+FCGWZxyr56kjvm95iiKjWk2XTOFGNoAmspU2Hf+Tg2pn8UwaQwmdmxh3ZuS7trNcZlqsOhlhAb0p7WFX4DgWtMeFq+ocHDz4/GJsGobYM63iQUPBnLY0AlhLuRIhlAgMBAAECggEADYy1TDMQFjheOX/SAJ+QsNtNPxdlRNyQ3/zTD0TGgKRcVbWmII25lfHq78g7ydnbFfatt2f389jO6MCz0Lh2YyWykSZ5WjbDKmoxWOV475NbkrMIlSyovc0m/G35Qdly6onpU1hNZFB7yRkODj9R2QN6l+hn9i4S6CGxPiWc/O7aSmJx/p2l4u3aBivkVi0LYaKgE1M3dvdSex08Czng9yhGDTZ2f3Wz4YgNX5XlqiS6DdCJN5ApgK2GLQNbjmxAe9EB+MNLx7L1KLXQXdSYEHedz3IDctiodXJLhY2TseFPoRg9WMVAMXTqTfsNA2p5btkyPzSc/pSgjTffAnOBGQKBgQDqtIfydJGbVGqFGDWurN+RmBEETosHYhe8S39VSWkQVwjAIXsWmHWz7a4KFx1QNZwPloyxjWf8EwdERduVpemzmVNzVJqjzih+vk/rdpPRKJ6x7k1qNtrtDCt6OxAqyNvqeWyPHN5Du1f8cUbe7zT4A4JJkYCrFHmWc/GInRd2jwKBgQCS4wMfRY2R4hSil+5Q1Nuk7snimj7OARJjffnc9cT9aialp4zancSQAINpfNKFKrwjwArHhnCN+Qr0qtMDhGskJ46w3+MR+CYG8/lMuSQM5hE9gkHDuId+2DmGzbX9ZONQc63HC8b4Qw3XjIsxeYMSTzDFEfV0pBdOc3gKRAirywKBgQDGyBQEAzp3Ri3Zf8GnqX7IvvRao3MY07mqnn6/6yby0eP1ZeXsI0A9HeazYRRQpLcCdM3AazVQx4T2C/yIaDbhB9En8tXuOmMNxX3GvW1ATpjpth0XAlK1RgNkyLVOp0Oq+SA6rYaJ8xf4FLCjjBFepQop6PQC8ZpxFM3SmMoQfQKBgGBAc+5NBHzg+galqlu7cAa/Fvnve1JAr40UouPhBOnOYm7QwWMMWR7Hx1Ubn1P18f03PZkLhrvxwvUa71Vxs0eoyD8tJr3CryCFRQq6k14EcK2uqmuXgupixCeKq0PVlYNFmk1BcWuDfRGPHjMYXgRkch/hKcf6Mu+MiM+pT0lLAoGAUcJzI84luxl4GjZQ4YT8QHN04Ox709GVW/TGYQhwPaTCVuj8Qb/GOZgKxb9Jflj2tB8PRqQEw8rlmGxC8eozltmamhr3FN9iuKHmaEFAgUnFKqfZxbPvTSPTkkaeQBJpE2nc0DqCTdt0XDjA5N73JIBfY7St9z4nvKdqjb4ZssI=");
        alipayRequest.setAlipayPulicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyN4dov3qQXKlN5kMm8yvbiNztIpcZ53/YdVhgwYroOnc0A7jJ8nZwHGK9bzkqp6pf2ZuWGeLirXnFoAaPbFORM6Zw0jtIT3OYzpHZGJpvk0nI7kX/10oxNI/x1XOZ3L8DmA1PsIinQOWAaflefJ0qjAnfsh6odBbMVkhv/j3PxibgY1qKfYsbFw3tzbEWg2fpVV9MJFEXOmDAnuQPOVHZIrD5PBZ+lHtmRp0NtGxL+5cDpCcv3HLIpWrTg2Tap1cVyVEDul3+wRK1LJ3cqAFsLb9weQBa1S/VpjWocOvBo79VtEmAPV9zyey+1mkV4Ok5RthRr8qGInylxnN8MIwawIDAQAB");
        alipayRequest.setApp_auth_token(token);

        //账单查询请求参数
        BillQueryRequest billRequest = new BillQueryRequest();
        billRequest.setCommunity_id(communityId);
        billRequest.setOut_room_id(roomId);
        billRequest.setPage_num(pageNum);
        billRequest.setPage_size(pageSize);
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        JSONObject obj = null;
        try {
            obj = alipayUtil.billBatchquery();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return obj.getJSONObject("alipay_eco_cplife_bill_batchquery_response");
    }

    @RequestMapping(value = "/deleteAlipayBill", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject deleteAlipayBill(String token, String communityId, String billId) {
        //支付宝公共请求参数
        AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
        alipayRequest.setAppId("2017071807800670");
        alipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGqxZ5m7EpP3RPH5UtBKHU1A5hPPdkKEnJF6UoSsO5TDWARWjUlwcNkZ8CEHHBU1nUbmaS+OjGzd6sNFsOh9iyH78K/RGnBZEC7PeoDvqu3vedzQk/fDsbU8+cLx6CFcVMg4cTZarsbaP5C2GTCbWgs6iL4T86FLI00qFXxgrQZwWZR6/bL2yYPkeaAhYav4tD7JgYqzGjaJumXcEiSt4ymM+FCGWZxyr56kjvm95iiKjWk2XTOFGNoAmspU2Hf+Tg2pn8UwaQwmdmxh3ZuS7trNcZlqsOhlhAb0p7WFX4DgWtMeFq+ocHDz4/GJsGobYM63iQUPBnLY0AlhLuRIhlAgMBAAECggEADYy1TDMQFjheOX/SAJ+QsNtNPxdlRNyQ3/zTD0TGgKRcVbWmII25lfHq78g7ydnbFfatt2f389jO6MCz0Lh2YyWykSZ5WjbDKmoxWOV475NbkrMIlSyovc0m/G35Qdly6onpU1hNZFB7yRkODj9R2QN6l+hn9i4S6CGxPiWc/O7aSmJx/p2l4u3aBivkVi0LYaKgE1M3dvdSex08Czng9yhGDTZ2f3Wz4YgNX5XlqiS6DdCJN5ApgK2GLQNbjmxAe9EB+MNLx7L1KLXQXdSYEHedz3IDctiodXJLhY2TseFPoRg9WMVAMXTqTfsNA2p5btkyPzSc/pSgjTffAnOBGQKBgQDqtIfydJGbVGqFGDWurN+RmBEETosHYhe8S39VSWkQVwjAIXsWmHWz7a4KFx1QNZwPloyxjWf8EwdERduVpemzmVNzVJqjzih+vk/rdpPRKJ6x7k1qNtrtDCt6OxAqyNvqeWyPHN5Du1f8cUbe7zT4A4JJkYCrFHmWc/GInRd2jwKBgQCS4wMfRY2R4hSil+5Q1Nuk7snimj7OARJjffnc9cT9aialp4zancSQAINpfNKFKrwjwArHhnCN+Qr0qtMDhGskJ46w3+MR+CYG8/lMuSQM5hE9gkHDuId+2DmGzbX9ZONQc63HC8b4Qw3XjIsxeYMSTzDFEfV0pBdOc3gKRAirywKBgQDGyBQEAzp3Ri3Zf8GnqX7IvvRao3MY07mqnn6/6yby0eP1ZeXsI0A9HeazYRRQpLcCdM3AazVQx4T2C/yIaDbhB9En8tXuOmMNxX3GvW1ATpjpth0XAlK1RgNkyLVOp0Oq+SA6rYaJ8xf4FLCjjBFepQop6PQC8ZpxFM3SmMoQfQKBgGBAc+5NBHzg+galqlu7cAa/Fvnve1JAr40UouPhBOnOYm7QwWMMWR7Hx1Ubn1P18f03PZkLhrvxwvUa71Vxs0eoyD8tJr3CryCFRQq6k14EcK2uqmuXgupixCeKq0PVlYNFmk1BcWuDfRGPHjMYXgRkch/hKcf6Mu+MiM+pT0lLAoGAUcJzI84luxl4GjZQ4YT8QHN04Ox709GVW/TGYQhwPaTCVuj8Qb/GOZgKxb9Jflj2tB8PRqQEw8rlmGxC8eozltmamhr3FN9iuKHmaEFAgUnFKqfZxbPvTSPTkkaeQBJpE2nc0DqCTdt0XDjA5N73JIBfY7St9z4nvKdqjb4ZssI=");
        alipayRequest.setAlipayPulicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyN4dov3qQXKlN5kMm8yvbiNztIpcZ53/YdVhgwYroOnc0A7jJ8nZwHGK9bzkqp6pf2ZuWGeLirXnFoAaPbFORM6Zw0jtIT3OYzpHZGJpvk0nI7kX/10oxNI/x1XOZ3L8DmA1PsIinQOWAaflefJ0qjAnfsh6odBbMVkhv/j3PxibgY1qKfYsbFw3tzbEWg2fpVV9MJFEXOmDAnuQPOVHZIrD5PBZ+lHtmRp0NtGxL+5cDpCcv3HLIpWrTg2Tap1cVyVEDul3+wRK1LJ3cqAFsLb9weQBa1S/VpjWocOvBo79VtEmAPV9zyey+1mkV4Ok5RthRr8qGInylxnN8MIwawIDAQAB");
        alipayRequest.setApp_auth_token(token);

        //账单查询请求参数
        BillDeleteRequest billRequest = new BillDeleteRequest();
        billRequest.setCommunity_id("A6IWVHER03301");
        List<String> ids = new ArrayList<>();
        ids.add(billId);
        billRequest.setBill_entry_id_list(ids);
        alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

        AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
        JSONObject obj = null;
        try {
            obj = alipayUtil.billDelete();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return obj.getJSONObject("alipay_eco_cplife_bill_delete_response");
    }
}
