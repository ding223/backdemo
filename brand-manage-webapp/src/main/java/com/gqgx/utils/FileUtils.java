package com.gqgx.utils;

import com.aliyun.oss.OSSClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {
	
	 /** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static String  readFileByLines(String fileName) {  
    	StringBuffer sb =new StringBuffer();
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
            	sb.append(tempString+"\r\n");
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return sb.toString();
    }
    
    /**
 	 * @param srcFile 文件目录
 	 * @return
 	 */
 	public static List<Map<String, Object>> getWindowsFileTree(String srcFile)
 	{
 		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
 		File file=new File(srcFile);
 		if(file.isDirectory()){
 			File[] listFiles = file.listFiles();
 			for(File f :listFiles ){
 	    		result.add(getFileTreeItem(f));
 			}
 		}else{
 			result.add(getFileTreeItem(file));
 		}
 		return result;
 	}
 	
 	public static Map<String, Object> getFileTreeItem(File file)
 	{
 		Map<String, Object> root = new HashMap<String, Object>();
 		root.put("text", file.getName());
 		root.put("id", file.getPath());
 		if(file.isDirectory()){
 			root.put("children", getWindowsFileTree(file.getPath()));
 		}
 		return root;
 	}
 	
 	
 	/**
 	 * @param srcFile 文件目录
 	 * @return
 	 */
 	public static List<Map<String, Object>> getLinuxFileTree(String srcFile)
 	{
 		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
 		/*File file=new File(srcFile);
 		if(file.isDirectory()){
 			File[] listFiles = file.listFiles();
 			for(File f :listFiles ){
 	    		result.add(getFileTreeItem(f));
 			}
 		}else{
 			result.add(getFileTreeItem(file));
 		}*/
 		return result;
 	}
 	
 	public static void main(String[] args) {
		// endpoint以杭州为例，其它region请按实际情况填写
		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "LTAI9LJLuBzc2v4Y";
		String accessKeySecret = "QlAQGZ6p37pxwM2fs35GMAQLah9ykN";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件
		ossClient.putObject("saas-images", "test1", new File("E:\\soft\\index.html"));
		// 关闭client
		ossClient.shutdown();
	}
  
}
