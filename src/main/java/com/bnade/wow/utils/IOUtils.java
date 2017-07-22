package com.bnade.wow.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO工具类
 *
 * Created by liufeng0103@163.com on 2017/6/30.
 */
public class IOUtils {

	/**
	 * 工具类，避免实例
	 */
	private IOUtils() {}

	/**
	 * InputStream转String
	 * 
	 * 参考http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
	 * 这种方式转化inputStream到String效率最高
	 * 
	 * @param inputStream 输入流
	 * @return 输入流中的文本内容
	 * @throws IOException IO异常
	 */
	public static String inputStreamToString(InputStream inputStream, String encoding) throws IOException {
		try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) != -1) {
				result.write(buffer, 0, length);
			}
			return result.toString(encoding);
		}
	}

}
