package com.gqgx.msg.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gqgx.common.springutils.Springs;
import com.gqgx.common.utils.CosConfig;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

public class CosFileUtils {

	public static Logger logger = LoggerFactory.getLogger(CosFileUtils.class);

	private static ClientConfig clientConfig = null;

	private static COSCredentials cred = null;

	private static String bucketName = null;

	static {
		CosConfig cos = Springs.getBean(CosConfig.class);
		// 这些属性可以通过cos控制台获取(https://console.qcloud.com/cos)
		// 初始化秘钥信息
		cred = new BasicCOSCredentials(cos.getSecretId(), cos.getSecretKey());
		// 初始化客户端配置
		clientConfig = new ClientConfig(new Region(cos.getRegion()));
		// 设置要操作的bucket
		bucketName = cos.getBucketName();
	}

	/**
	 * @Description 上传文件
	 * @author hezhijun
	 * @param cosFilePath
	 * @param contentBuffer
	 * @return
	 */
	public static String uploadFile(String cosFilePath, byte[] contentBuffer) {
		// 初始化cosClient
		COSClient cosClient = new COSClient(cred, clientConfig);
		try {

			InputStream input = new ByteArrayInputStream(contentBuffer);
			ObjectMetadata objectMetadata = new ObjectMetadata();
			// 从输入流上传必须制定content length, 否则http客户端可能会缓存所有数据，存在内存OOM的情况
			objectMetadata.setContentLength(contentBuffer.length);
			// 默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, cosFilePath, input, objectMetadata);
			PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

			// 设置存储类型, 默认是标准(Standard), 低频(standard_ia), 近线(nearline)
			putObjectRequest.setStorageClass(StorageClass.Standard_IA);
			// putobjectResult会返回文件的etag
			String uploadFileRet = putObjectResult.getETag();
			cosClient.shutdown();
			return uploadFileRet;
		} catch (CosServiceException e) {
			logger.error(e.getMessage());
			cosClient.shutdown();
			return null;
		} catch (CosClientException e) {
			logger.error(e.getMessage());
			cosClient.shutdown();
			return null;
		}
	}

	/**
	 * @Description 下载文件
	 * @author hezhijun
	 * @param cosFilePath
	 * @return
	 */
	public static InputStream downloadFile(String cosFilePath) {
		// 初始化cosClient
		COSClient cosClient = new COSClient(cred, clientConfig);
		try {
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, cosFilePath);
			COSObject object = cosClient.getObject(getObjectRequest);
			InputStream input = object.getObjectContent();
			cosClient.shutdown();
			return input;
		} catch (Exception e) {
			logger.error(e.getMessage());
			cosClient.shutdown();
			return null;
		}
	}

	/**
	 * @Description 删除文件
	 * @author hezhijun
	 * @param cosFilePath
	 * @return
	 */
	public static void delFile(String cosFilePath) {
		// 初始化cosClient
		COSClient cosClient = new COSClient(cred, clientConfig);
		try {
			cosClient.deleteObject(bucketName, cosFilePath);
			cosClient.shutdown();
		} catch (CosServiceException e) {
			logger.error(e.getMessage());
			cosClient.shutdown();
		} catch (CosClientException e) {
			logger.error(e.getMessage());
			cosClient.shutdown();
		}
	}
}
