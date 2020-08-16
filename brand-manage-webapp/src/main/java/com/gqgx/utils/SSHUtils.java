package com.gqgx.utils;

import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.sftp.SftpFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSHUtils {
	
	@SuppressWarnings("unchecked")
 	public static List<Map<String, Object>> getLinuxFileTree(SftpClient sftpClient ,String srcFile) throws IOException
 	{
 		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
 		List<SftpFile> list=sftpClient.ls(srcFile);
 		for(SftpFile f : list)
 		{
 			result.add(getLinuxFileTreeItem(sftpClient,f));
 		}
 		return result;
 	}
	
	public static Map<String, Object> getLinuxFileTreeItem(SftpClient sftpClient,SftpFile file) throws IOException
 	{
		System.out.println("file.getAbsolutePath()========"+file.getAbsolutePath());
 		Map<String, Object> root = new HashMap<String, Object>();
 		root.put("text", file.getFilename());
 		root.put("id", file.getAbsolutePath());
 		if(file.isDirectory())
 		{
 			root.put("children", getLinuxFileTree(sftpClient,file.getAbsolutePath()));
 		}
 		return root;
 	}

	public static void main(String[] args) throws IOException {
		SshClient client=new SshClient();
        client.connect("139.199.152.200");
        //设置用户名和密码
        PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();
        pwd.setUsername("root");
        pwd.setPassword("saas@CLIENT?");
        int result=client.authenticate(pwd);
        if(result==AuthenticationProtocolState.COMPLETE){//如果连接完成
            System.out.println("==============="+result);
            String srcFile="/dum_data/apache-tomcat-7.0.56/webapps/ROOT/WEB-INF/view";
            SftpClient sftpClient = client.openSftpClient();
            List<Map<String, Object>> linuxFileTree = getLinuxFileTree(sftpClient, srcFile);
            System.out.println(linuxFileTree);
        }
	}
}
