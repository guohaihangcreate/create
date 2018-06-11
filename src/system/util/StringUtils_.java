package system.util;

import java.io.UnsupportedEncodingException;


public class StringUtils_ {

	public StringUtils_() {
	}

	
	// 中文字符串转换
	public static String chineseStrGBK(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes("ISO8859-1");
			String temp = new String(tempArray, "GBK");
			return temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	// 中文字符串转换，用于 js 中 encodeURI() 方式提交的参数转换
	public static String chineseStrUTF8(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes("ISO8859-1");
			String temp = new String(tempArray, "UTF8");
			return temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	// URL中的中文字符串转换
	public static String URLEncode(String str) {
		String returnValue = "";
		try {
			if (str != null) {
				returnValue = java.net.URLEncoder.encode(str, "GBK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	// URL中的中文字符串还原，没什么用还是乱码，用chineseStr()方法
	public static String URLDecode(String str) {
		String returnValue = "";
		try {
			if (str != null) {
				returnValue = java.net.URLDecoder.decode(str, "GBK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}	
}
