package com.hellome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hellome.model.BaseModel;
import com.hellome.util.FileUtil;

/**
 * 
 * @description image获取图片
 * @author hyy
 * @date 2017�?11�?23�?
 */

@Controller
@RequestMapping("/image/")
public class ImageController {

	@RequestMapping(value = "getBanner", method = RequestMethod.GET)
	public @ResponseBody BaseModel getBanner(HttpServletRequest request, Model model) {
		BaseModel baseModel = new BaseModel();
		List<String>  pathList = FileUtil.getBannerImages();
		if(pathList !=null && pathList.size()>0) {
			baseModel.setResult(true);
			baseModel.setMsg("OK");
		}else {
			baseModel.setResult(false);
			baseModel.setMsg("没有图片");
		}
		baseModel.setData(FileUtil.getBannerImages());
		return baseModel;
	}
}
