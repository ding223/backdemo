package com.gqgx.action.common;

import com.gqgx.common.entity.vo.UploadFileVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件
 * @author Administrator
 *
 */
@RequestMapping("/file")
@Controller
public class FileUpLoadAction {

	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public UploadFileVo upload(MultipartHttpServletRequest request, HttpServletResponse response, String uploadName) throws IOException {
		UploadFileVo file = new UploadFileVo();
		MultipartFile uploadFile = request.getFile(request.getFileNames().next());
		if (!Objects.isEmpty(uploadFile)) file = fileUploadService.uploadFile(uploadFile);
		return file;
	}
	
	@RequestMapping("/ueditorUpload")
	@ResponseBody
	public Map<String,Object> ueditorUpload(MultipartHttpServletRequest request, HttpServletResponse response, String uploadName) throws IOException {
		response.setContentType("application/json");
		UploadFileVo file = new UploadFileVo();
		MultipartFile uploadFile = request.getFile(request.getFileNames().next());
		if (!Objects.isEmpty(uploadFile)) file = fileUploadService.uploadFile(uploadFile);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", "SUCCESS");
		map.put("url", file.getFileUrl());
		map.put("title", file.getFileName());
		map.put("original", file.getFileName());
		return map;
	}
}