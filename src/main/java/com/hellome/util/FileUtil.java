package com.hellome.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hellome.constant.Constant;

/**
 * 
 * @author ASUS
 *
 */

public class FileUtil {

	/**
	 * 获取Banner图片
	 * @return
	 */
	public static List<String> getBannerImages() {
		List<String> filePath = new ArrayList<String>();
//		File file = new File(Constant.BANNER_PATH);
//		File[] files = file.listFiles();
//		if(files != null) {
//			for (int i = 0; i < files.length; i++) {
//				if (files[i].getName().endsWith(".jpg") || files[i].getName().endsWith(".png")
//						|| files[i].getName().endsWith(".bmp") || files[i].getName().endsWith(".gif")) {
//					filePath.add(Constant.BANNER_IMAGE_PATH + files[i].getName());
//				}
//			}
//		}
		return filePath;
	}
}
