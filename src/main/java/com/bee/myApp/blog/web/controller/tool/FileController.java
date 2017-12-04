package com.bee.myApp.blog.web.controller.tool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @Description TODO
 * @author Linfeng
 * @date 2017年3月28日 下午3:15:45
 * 
 **/
@Controller
@RequestMapping(value="/tool/file")
public class FileController {

	public Object uploadImage(CommonsMultipartFile file){
		
		
		return null;
	}
}
