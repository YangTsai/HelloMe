package com.hellome.constant;

import com.hellome.util.IPAddressUtil;

public class Constant {

	// 本地电脑IP
	public static final String IP_LOCALHOST = IPAddressUtil.getLocalhostIp();
	// 服务器IP
	public static final String IP_NET = "47.104.26.192";
	// 服务器图片存储路径基准
	public static final String IMAGE_PATH = "/home/YangTsai/images";
	// 本地图片存储路径基准
	public static final String IMAGE_PATH_TEST = "D:\\Java\\images\\banner";
	// 服务器访问url基准
	public static final String BASE_URL = "http://" + IP_LOCALHOST + ":8080";
	// banner图片访问路径
	public static final String BANNER_PATH = BASE_URL + "/images/banner/";
	// 头像访问路径
	public static final String HEAD_PATH = BASE_URL + "/images/head/";

}
