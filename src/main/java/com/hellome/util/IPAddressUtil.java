package com.hellome.util;

import java.net.InetAddress;

public class IPAddressUtil {

	/**
	 * 获取本机IP
	 * 
	 * @return
	 */
	public static String getLocalhostIp() {
		String localip = null;
		InetAddress ia = null;
		try {
			ia = ia.getLocalHost();
			String localname = ia.getHostName();
			localip = ia.getHostAddress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localip;
	}
}
