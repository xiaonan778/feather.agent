/*package com.feather.f3.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;



*//** 
 * @Description 
 * @author DCJ
 * @date 2015-8-12 上午10:39:13 
 * @version V1.0
 *//*

public class HttpUtil {

	static final Logger logger = Logger.getLogger(HttpUtil.class);
	private final static String APPLICATION_JSON = "application/json;charset=UTF-8";
	
    public static BackResultEntity doGet(String url) {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet(url);
        BackResultEntity result = null;
        String str = "";
        try {
            // 执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            // 响应状态
            logger.info("doGet url:"+url+" - status:" + httpResponse.getStatusLine());
            // 判断响应实体是否为空
            if (entity != null) {
                str = EntityUtils.toString(entity);
                logger.debug("response content:" + str);
            }
            result = new BackResultEntity(tfCode(httpResponse.getStatusLine().getStatusCode()),httpResponse.getStatusLine().toString(),str,httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
        	logger.error(e.getMessage());
        	return new BackResultEntity(BackResultEntity.STATUS_ERROR, e.getMessage());
        } finally {
            try {
                if (closeableHttpClient != null){
                    closeableHttpClient.close();
                }
            } catch (IOException e) {
            	logger.error(e.getMessage());
                return new BackResultEntity(BackResultEntity.STATUS_ERROR, e.getMessage());
            }
        }
        return result;
    }
	
	public static BackResultEntity doPost(String url,String json){  
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPost post = new HttpPost(url);  
        BackResultEntity result = null;
        String str = "";
        try {  
            StringEntity s = new StringEntity(json);  
            s.setContentEncoding("UTF-8");  
            s.setContentType(APPLICATION_JSON);  
            post.setEntity(s);  
            HttpResponse httpResponse = client.execute(post);
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            // 响应状态
            logger.info("doPost url:"+url+" - status:" + httpResponse.getStatusLine());
            // 判断响应实体是否为空
            if (entity != null) {
                str = EntityUtils.toString(entity);
                logger.debug("response content:" + str);
            }
            result = new BackResultEntity(tfCode(httpResponse.getStatusLine().getStatusCode()),httpResponse.getStatusLine().toString(),str,httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {  
        	logger.error(e.getMessage());
            return new BackResultEntity(BackResultEntity.STATUS_ERROR, e.getMessage());
        } 
        return result;
    }
	
	*//**
	 * 带header的Http Post 请求
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 *//*
	public static BackResultEntity doPost(String url,String json, Map<String, String> headers){  
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPost post = new HttpPost(url);  
        if (headers != null) {  
            Set<String> keys = headers.keySet();  
            for (Iterator<String> i = keys.iterator(); i.hasNext();) {  
                String key = (String) i.next();  
                post.addHeader(key, headers.get(key));  
            }  
        }  
        BackResultEntity result = null;
        String str = "";
        try {  
            StringEntity s = new StringEntity(json, "UTF-8");  
            s.setContentEncoding("UTF-8");  
            s.setContentType(APPLICATION_JSON);  
            post.setEntity(s);  
            HttpResponse httpResponse = client.execute(post);
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            // 响应状态
            logger.info("doPost url:"+url+" - status:" + httpResponse.getStatusLine());
            // 判断响应实体是否为空
            if (entity != null) {
                str = EntityUtils.toString(entity);
                logger.debug("response content:" + str);
            }
            result = new BackResultEntity(tfCode(httpResponse.getStatusLine().getStatusCode()),httpResponse.getStatusLine().toString(),str,httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {  
        	logger.error(e.getMessage());
            return new BackResultEntity(BackResultEntity.STATUS_ERROR, e.getMessage());
        } 
        return result;
    }
	
	
	public static BackResultEntity doPut(String url,String json){  
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPut put = new HttpPut(url);  
        BackResultEntity result = null;
        String str= "";
        try {  
            StringEntity s = new StringEntity(json);  
            s.setContentEncoding("UTF-8");  
            s.setContentType(APPLICATION_JSON);  
            put.setEntity(s);  
            HttpResponse httpResponse = client.execute(put);
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            // 响应状态
            logger.info("doPut url:"+url+" - status:" + httpResponse.getStatusLine());
            // 判断响应实体是否为空
            if (entity != null) {
                str = EntityUtils.toString(entity);
                logger.debug("response content:" + str);
            }
            result = new BackResultEntity(tfCode(httpResponse.getStatusLine().getStatusCode()),httpResponse.getStatusLine().toString(),str,httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {  
        	logger.error(e.getMessage());
            return new BackResultEntity(BackResultEntity.STATUS_ERROR, e.getMessage());
        } 
        return result;
    }
	
	public static BackResultEntity doDelete(String url){  
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient client = httpClientBuilder.build();
        HttpDelete delete = new HttpDelete(url);  
        BackResultEntity result = null;
        String str = "";
        try {  
            HttpResponse httpResponse = client.execute(delete);
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            // 响应状态
            logger.info("doDelete url:"+url+" - status:" + httpResponse.getStatusLine());
            // 判断响应实体是否为空
            if (entity != null) {
                str = EntityUtils.toString(entity);
                logger.debug("response content:" + str);
            }
            result = new BackResultEntity(tfCode(httpResponse.getStatusLine().getStatusCode()),httpResponse.getStatusLine().toString());
        } catch (Exception e) {  
        	logger.error(e.getMessage());
            return new BackResultEntity(BackResultEntity.STATUS_ERROR, e.getMessage());
        } 
        return result;
    }
	
	private static int tfCode(int status){
		if(status<200||status>=300){
			return BackResultEntity.STATUS_ERROR;
		}
		return BackResultEntity.STATUS_SUCCESS;
	}
	

}
*/