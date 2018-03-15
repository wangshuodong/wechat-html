package com.wangsd.common.utils;

import java.nio.charset.Charset;

/**
 * url处理工具类
 * @author L.cm
 */
public class URLUtils extends org.springframework.web.util.UriUtils {

	/**
	 * url 编码
	 * @param source url
	 * @param charset 字符集
	 * @return 编码后的url
	 */
	public static String encodeURL(String source, Charset charset) {
		return URLUtils.encode(source, charset.name());
	}

	public static void main(String[] args) {
		System.out.println(encodeURL("http://www.yhwpay.com/wechat/index", Charsets.UTF_8));
	}
}
