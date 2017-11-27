package com.hellome.util;

import java.util.UUID;

public class UUIDUtil {

	/**
	 * 获取32位UUID
	 * 
	 * @return
	 */
	public static String getUUid() {

		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");// 替换掉中间的那个斜杠
		return id;

	}

}
