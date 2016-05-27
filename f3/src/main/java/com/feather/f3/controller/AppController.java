
/**   
 * @Title: ApiController.java 
 * @Package: com.feather.agent 
 * @Description: TODO
 * @author DCJ  
 * @date 2016-5-3 上午11:15:18 
 * @version 1.0 
 */


package com.feather.f3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feather.f3.util.RuntimeUtil;
import com.feather.f3.util.ShellResult;



/** 
 * @Description 
 * @author DCJ
 * @date 2016-5-3 上午11:15:18 
 * @version V1.0
 */

@Controller
@RequestMapping(value = "/f3/app")
public class AppController {
	
	Logger logger = Logger.getLogger(AppController.class);
	String executeStr = "Execute command:";
	String errorStr = "Error message:";
	
	
	/**
	 * 
	 * @Description 启动Zookeeper镜像
	 * @author DCJ
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/startDocker", method = RequestMethod.POST,  produces="application/json")
	public @ResponseBody ResponseEntity<Object> startDocker(String part , HttpServletResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "F") ;
		String command = "docker run "+part.trim();
		ShellResult sr = RuntimeUtil.execute(command);
		logger.info(executeStr+command);
		if(sr.getCode()!=ShellResult.CODE_SUCCESS){
			logger.error(errorStr+sr.getMessage());
			result.put("message", sr.getMessage()) ;
			return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
		}
		String msg = "Start docker success";
		logger.info(msg);
		result.put("status", "S") ;
		result.put("message", msg) ;
        return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @Description 启动Zookeeper镜像
	 * @author DCJ
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/stopDocker", method = RequestMethod.POST,  produces="application/json")
	public @ResponseBody ResponseEntity<Object> stopDocker(String part, HttpServletResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "F") ;
		String command = "docker rm -f "+part.trim();
		ShellResult sr = RuntimeUtil.execute(command);
		logger.info(executeStr+command);
		if(sr.getCode()!=ShellResult.CODE_SUCCESS){
			logger.error(errorStr+sr.getMessage());
			result.put("message", sr.getMessage()) ;
			return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
		}
		String msg = "Stop docker success";
		logger.info(msg);
		result.put("status", "S") ;
		result.put("message", msg) ;
        return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @Description 启动Zookeeper镜像
	 * @author DCJ
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/startZookeeper", method = RequestMethod.POST,  produces="application/json")
	public @ResponseBody ResponseEntity<Object> startZookeeper(HttpServletResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "F") ;
		String command = "docker run --name zookeeper -d -p 2181:2181 garland/zookeeper";
		ShellResult sr = RuntimeUtil.execute(command);
		logger.info(executeStr+command);
		if(sr.getCode()!=ShellResult.CODE_SUCCESS){
			logger.error(errorStr+sr.getMessage());
			result.put("message", sr.getMessage()) ;
			return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
		}
		String msg = "Start docker success";
		logger.info(msg);
		result.put("status", "S") ;
		result.put("message", msg) ;
        return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @Description 停止Zookeeper镜像
	 * @author DCJ
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/stopZookeeper", method = RequestMethod.POST,  produces="application/json")
	public @ResponseBody ResponseEntity<Object> stopZookeeper(HttpServletResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "F") ;
		String command = "docker rm -f zookeeper";
		ShellResult sr = RuntimeUtil.execute(command);
		logger.info(executeStr+command);
		if(sr.getCode()!=ShellResult.CODE_SUCCESS){
			logger.error(errorStr+sr.getMessage());
			result.put("message", sr.getMessage()) ;
			return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
		}
		String msg = "Stop docker success";
		logger.info(msg);
		result.put("status", "S") ;
		result.put("message",msg) ;
        return new ResponseEntity<Object>(result, headers, HttpStatus.OK);
	}
	

	
	
	
	
}
