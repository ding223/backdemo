package com.gqgx.utils;

import com.gqgx.common.web.PropertyHolder;
import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SFTPUtil {
	
	/**
     * 连接sftp服务器
     * @param host 远程主机ip地址
     * @param port sftp连接端口，null 时为默认端口
     * @param user 用户名
     * @param password 密码
     * @return
     * @throws JSchException 
     */
    public static Session connect() throws JSchException{
        Session session = null;
        String linuxIP= PropertyHolder.getStringProperty("linux_ip");
		String userName= PropertyHolder.getStringProperty("user_name");
		String password= PropertyHolder.getStringProperty("user_password");
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(userName, linuxIP);
            session.setPassword(password);
            //设置第一次登陆的时候提示，可选值:(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            //30秒连接超时
            session.connect(30000);
        } catch (JSchException e) {
            e.printStackTrace();
            System.out.println("SFTPUitl 获取连接发生错误");
            throw e;
        }
        return session;
    }
    
    /**
     * 连接sftp服务器
     * @param host 远程主机ip地址
     * @param port sftp连接端口，null 时为默认端口
     * @param user 用户名
     * @param password 密码
     * @return
     * @throws JSchException 
     */
    public static Session connect(String linuxIP,String userName,String password) throws JSchException{
        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(userName, linuxIP);
            session.setPassword(password);
            //设置第一次登陆的时候提示，可选值:(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            //30秒连接超时
            session.connect(30000);
        } catch (JSchException e) {
            e.printStackTrace();
            System.out.println("SFTPUitl 获取连接发生错误");
            throw e;
        }
        return session;
    }
    
    public static List<Map<String, Object>> loadLinuxFileTree(String srcFile)
    {
    	Session session=null;ChannelSftp sftp=null;
    	List<Map<String, Object>> linuxFileTree=null;
		try {
			session = connect();
	    	Channel channel = session.openChannel("sftp");
	    	channel.connect();
	        sftp  = (ChannelSftp) channel;
			linuxFileTree = getLinuxJsTree(sftp, srcFile);
		}  catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sftp != null)sftp.disconnect();
            if(session != null)session.disconnect();
        }
    	return linuxFileTree;
    }
    
	public static Map<String, Object> getFileTreeItem(ChannelSftp sftp ,LsEntry file,String srcFile) throws Exception
 	{
		String filePath=srcFile+"/"+file.getFilename();
 		Map<String, Object> root = new HashMap<String, Object>();
 		root.put("text", file.getFilename());
 		root.put("id",filePath);
 		SftpATTRS attrs = file.getAttrs();
 		if(attrs.getPermissionsString().startsWith("d")){ //linux 系统两个的默认目录
 			root.put("children", getLinuxJsTree(sftp, filePath));
 		}
 		return root;
 	}
    
 	
	@SuppressWarnings("unchecked")
 	public static List<Map<String, Object>> getLinuxJsTree(ChannelSftp sftp ,String srcFile) throws Exception
 	{
 		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
 		Vector<LsEntry> conts = sftp.ls(srcFile);
 		for (Iterator<LsEntry> iterator = conts.iterator(); iterator.hasNext();) {
            LsEntry obj =  iterator.next();
            if(".".equals(obj.getFilename())||"..".equals(obj.getFilename())){
            	continue;
            }
            result.add(getFileTreeItem(sftp,obj,srcFile));
        }
 		return result;
 	}
	
	public static String getFileContentByLinux(String filePath){
		Session session=null;ChannelSftp sftp=null;
		try {
			session = connect();
	    	Channel channel = session.openChannel("sftp");
	    	channel.connect();
	        sftp  = (ChannelSftp) channel;
	        InputStream inputStream = sftp.get(filePath);
	        InputStreamReader bsr=new InputStreamReader(inputStream);
	        BufferedReader reader=new BufferedReader(bsr);
	        StringBuffer sb =new StringBuffer();
            String tempString = null;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
            	sb.append(tempString+"\r\n");
            }  
            inputStream.close();
            bsr.close();
            reader.close();  
	        return sb.toString();
	        
		}  catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sftp != null)sftp.disconnect();
            if(session != null)session.disconnect();
        }
		return null;
	}
	    
	
	public static void saveLinuxFile(String filePath,String fileContent){
		Session session=null;ChannelSftp sftp=null;
		try {
			session = connect();
	    	Channel channel = session.openChannel("sftp");
	    	channel.connect();
	        sftp  = (ChannelSftp) channel;
	        ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(fileContent.getBytes());
	        sftp.put(tInputStringStream, filePath);
	        tInputStringStream.close();
		}  catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sftp != null)sftp.disconnect();
            if(session != null)session.disconnect();
        }
	}
	
	public static void copyWwwtemplate(String baseDir,String wwwtemplate,String cpDir) throws Exception{
		
		Session session=null;ChannelSftp sftp=null;
		try {
			session = connect();
			ChannelExec exec = (ChannelExec) session.openChannel("exec");  
			String command=" cp -rf " +baseDir+"/"+wwwtemplate+" "+baseDir+"/"+cpDir;
			System.out.println("command======================"+command);
			exec.setCommand(command);  
		    exec.connect();
		    exec.disconnect();  
			session.disconnect();
		}  catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sftp != null)sftp.disconnect();
            if(session != null)session.disconnect();
        }
		
	}
	
	    
	public static void main(String[] args) {
		
	}
}
