package com.gqgx.common.service;

import com.gqgx.common.entity.vo.UploadFileVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件操作业务类
 */
public interface FileUploadService {
    /**
     * 上传文件
     * @param uploadFile
     * @return
     */
    public UploadFileVo uploadFile(MultipartFile uploadFile);
}
