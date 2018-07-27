package com.wangsd.common.base;

/**
 * 统一封装API返回信息
 * 千万别加@Entity 否则Hibernate会给你创建表
 * Created by bekey on 2017/12/10.
 */
public class RestResult {
    //状态码
    private int code;
    //消息
    private String message;
    //额外的内容
    private Object data;
    //请求url地址
    private String url;

    public RestResult() {

    }

    public RestResult(int code, String message, Object data, String url) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.url = url;
    }

    public static RestResult fail(String message) {
        return new RestResult(50000, message, null, "");
    }

    public static RestResult fail(String message, String url) {
        return new RestResult(50000, message, null, url);
    }

    public static RestResult fail(int code, String message) {
        return new RestResult(code, message, null, null);
    }

    public static RestResult success() {
        return new RestResult(20000, "success", null, "");
    }

    public static RestResult success(Object data) {
        return new RestResult(20000, "success", data, "");
    }

    public static RestResult success(String message, Object data) {
        return new RestResult(20000, message, data, "");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
