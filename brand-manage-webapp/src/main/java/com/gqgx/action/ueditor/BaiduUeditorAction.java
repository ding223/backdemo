package com.gqgx.action.ueditor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 百度富文本
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/baiduUeditor")
public class BaiduUeditorAction {

	@RequestMapping("/init")
	public void init(HttpServletRequest request,HttpServletResponse response){
		try {
			org.springframework.core.io.Resource res = new ClassPathResource("config.json");
		   InputStream is = null;
		   response.setHeader("Content-Type" , "text/html");
		   try {
		      is = new FileInputStream(res.getFile());
		      StringBuffer sb = new StringBuffer();
		      byte[] b = new byte[1024];
		      int length=0;
		      while(-1!=(length=is.read(b))){
		         sb.append(new String(b,0,length,"utf-8"));
		      }
		      String result = sb.toString().replaceAll("/\\*(.|[\\r\\n])*?\\*/","");
		      JSONObject json = JSON.parseObject(result);
		      PrintWriter out = response.getWriter();
		      out.print(json.toString());
		   } catch (IOException e) {
		      e.printStackTrace();
		   }finally {
		      try {
		         is.close();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
