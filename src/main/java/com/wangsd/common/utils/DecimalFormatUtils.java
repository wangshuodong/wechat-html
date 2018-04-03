package com.wangsd.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class DecimalFormatUtils {
	private static DecimalFormat df;

	/**
	 * 根据pattern格式化double
	 * @param pattern
	 * @param  d
	 * @return
	 */
	public static double format(String pattern, double d) {
		df = new DecimalFormat();
		df.applyPattern(pattern);
		String str = df.format(d);
		return Double.parseDouble(str);
	}

	/**
	 * 根据pattern格式化double，返回String
	 * @param pattern
	 * @param d
	 * @return
	 */
	public static String formatDoubleToString(String pattern, double d) {
		df = new DecimalFormat();
		df.applyPattern(pattern);
		return df.format(d);
	}

	/**
	 * 根据pattern格式化float
	 * @param pattern
	 * @param  f
	 * @return
	 */
	public static float format(String pattern, float f) {
		df = new DecimalFormat();
		df.applyPattern(pattern);
		String str = df.format(f);
		return Float.parseFloat(str);
	}

	/**
	 * 根据pattern格式化long
	 * @param pattern
	 * @param f
	 * @return
	 */
	public static String format(String pattern, long f) {
		df = new DecimalFormat();
		df.applyPattern(pattern);
		return df.format(f);
	}

	/**
	 * 格式化double，返回2位小数点
	 * @param
	 * @return
	 */
	public static double format(double d) {
		df = new DecimalFormat();
		df.applyPattern("#.##");
		String str = df.format(d);
		return Double.parseDouble(str);
	}

	/**
	 * 格式化float，返回2位小数点
	 * @param
	 * @return
	 */
	public static float format(float f) {
		df = new DecimalFormat();
		df.applyPattern("#.##");
		String str = df.format(f);
		return Float.parseFloat(str);
	}

	/**
	 * 根据pattern格式化int
	 * @param pattern
	 * @param
	 * @return
	 */
	public static String format(String pattern, int i) {
		df = new DecimalFormat();
		df.applyPattern(pattern);
		String str = df.format(i);
		return str;
	}

	/**
	 * 根据pattern格式化BigDecimal
	 * @param pattern
	 * @param
	 * @return String
	 * <pre>
	 * Ex:
	 *  DecimalFormatUtils.financeFormat("##,###.000",new BigDecimal(123456.123))
	 * </pre>
	 */
	public static String financeFormat(String pattern, BigDecimal bigDecimal) {
		df = new DecimalFormat();
		df.applyPattern(pattern);
		String str = df.format(bigDecimal);
		return str;
	}

	public static void main(String args[]) {
		//System.out.println(format("#,##0.00",2899.049999));
		System.out.println(format(2899.049999));
	}
}
