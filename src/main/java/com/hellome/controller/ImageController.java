package com.hellome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellome.pojo.JsonModel;
import com.hellome.util.FileUtil;

/**
 * 
 * @description 图片相关接口
 * @author hyy
 * @date 2017年12月4日
 */

@Controller
@RequestMapping("/images")
public class ImageController {

	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	public @ResponseBody JsonModel getBanner(HttpServletRequest request, Model model) {
		JsonModel baseModel = new JsonModel();
		List<String>  pathList = FileUtil.getBannerImages();
		if(pathList !=null && pathList.size()>0) {
			baseModel.setResult(true);
			baseModel.setMsg("OK");
		}else {
			baseModel.setResult(false);
			baseModel.setMsg("没有图片");
		}
		baseModel.setData(pathList);
		return baseModel;
	}
}
