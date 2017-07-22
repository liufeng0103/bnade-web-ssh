package com.bnade.wow.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * http工具类
 * 对http的简单封装只能满足自己的基本需要
 * 
 * Created by liufeng0103@163.com on 2017/6/30.
 */
public class HttpUtils {

	private static final int CONNECT_TIMEOUT = 5000;
	private static final int READ_TIMEOUT = 5000;

	/**
	 * 工具类，避免实例
	 */
	private HttpUtils() {}
	
	/**
	 * 通过http的HEAD方式获取url返回的http响应头
	 *
	 * @param url 资源URL
	 * @return 响应头封装在Map中
	 * @throws IOException IO异常
	 */
	public static Map<String, List<String>> getHeaderFields(String url) throws IOException {
		HttpURLConnection conn = null;
		try {
			conn = getHttpURLConnection(url);
			// Request Method
			conn.setRequestMethod("HEAD");
			return conn.getHeaderFields();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	
	/**
	 * 通过http的GET方式获取url的文本内容
	 * 如果服务器端支持gzip压缩，将获取gzip压缩的文件，并解压成文本
	 *
	 * @param url 资源URL
	 * @return	响应体的文本内容
	 * @throws IOException IO异常
	 */
	public static String get(String url) throws IOException {
		HttpURLConnection conn = null;
		InputStream is = null;
		String result;
		try {
			conn = getHttpURLConnection(url);
			// 查看Response Headers是否通过gzip压缩
			if ("gzip".equals(conn.getHeaderField("Content-Encoding"))) {
				is = new GZIPInputStream(conn.getInputStream());
			} else {
				is = conn.getInputStream();
			}
			result = IOUtils.inputStreamToString(is, "utf-8");
		} finally {
			if (is != null) {
				is.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return result;
	}

	/**
	 * 获取URL的HttpURLConnection
	 *
	 * @param url URL
	 * @return HttpURLConnection
	 * @throws IOException IO异常
	 */
	private static HttpURLConnection getHttpURLConnection(String url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

		// 设置超时，防止网络不好时阻塞线程
		conn.setConnectTimeout(CONNECT_TIMEOUT);
		conn.setReadTimeout(READ_TIMEOUT);

		// 设置请求头
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch, br");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		// 模拟Mozilla浏览器
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		return conn;
	}

}

