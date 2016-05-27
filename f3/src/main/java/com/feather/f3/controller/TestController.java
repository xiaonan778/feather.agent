
/**   
 * @Title: ApiController.java 
 * @Package: com.feather.agent 
 * @Description: TODO
 * @author DCJ  
 * @date 2016-5-3 上午11:15:18 
 * @version 1.0 
 */


package com.feather.f3.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @Description 
 * @author DCJ
 * @date 2016-5-3 上午11:15:18 
 * @version V1.0
 */

@Controller
@RequestMapping(value = "/f3")
public class TestController {
	
	//创建目录
	@RequestMapping(value = "/test", method = RequestMethod.GET,  produces="application/json")
	public @ResponseBody ResponseEntity<Object> print(HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("message", "测试访问成功") ;
        result.put("status", "S") ;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
        return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
	}
	
	
	
}
