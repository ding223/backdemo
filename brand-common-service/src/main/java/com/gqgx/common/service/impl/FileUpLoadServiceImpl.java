package com.gqgx.common.service.impl;

import com.gqgx.common.entity.vo.UploadFileVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.service.FileUploadService;
import com.gqgx.common.springutils.Springs;
import com.gqgx.common.utils.CosConfig;
import com.gqgx.msg.utils.CosFileUtils;
import com.gqgx.msg.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileUpLoadServiceImpl implements FileUploadService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UploadFileVo uploadFile(MultipartFile uploadFile) {
		UploadFileVo file = new UploadFileVo();
		int index = uploadFile.getOriginalFilename().lastIndexOf(".") + 1;
		String suffix = (index <= 0 ? "" : uploadFile.getOriginalFilename().substring(index));
		String uuid = "/" + MD5Utils.MD5Encode(UUID.randomUUID().toString()) + "." + suffix;
		try {
			byte[] bytes = uploadFile.getBytes();
			String result = CosFileUtils.uploadFile(uuid, bytes);
			if(!Objects.isEmpty(result)) {
				CosConfig cos = Springs.getBean(CosConfig.class);
				file.setFileName(uploadFile.getOriginalFilename());
				file.setFileUrl(cos.getDomain()+uuid);
			}
		} catch (Exception e) {
			logger.error("上传文件异常！", e);
		}
		return file;
	}
}
