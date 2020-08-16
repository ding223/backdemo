package com.gqgx.utils;

import java.io.*;

public class LzhOldTest {
private static int count=0;
	
    public static void main(String[] args) {
    	
    	  String filename="营销客户数据编码后";
    	  String lzhdatanew="lzhdatanew";
    	
    	  FileInputStream fis = null;
    	  InputStreamReader isr = null;
    	  BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
    	  
    	  try {
    	   String filenamenew="E:\\"+lzhdatanew+"\\"+filename+".csv";
    	   FileWriter writer = new FileWriter(filenamenew, true);  
    	   String str = "";
    	   fis = new FileInputStream("E:\\lzhdata\\"+filename+".csv");// FileInputStream
    	   // 从文件系统中的某个文件中获取字节
    	    isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
    	    br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
    	   int len=0;
    	   int index=0;
    	   str = br.readLine();
    	   writer.write(str+"\r\n");
    	   //writeLineFile(filenamenew, str);
    	   len=getNumcount(str,";");
    	   while ((str = br.readLine()) != null)
    	   {
    		   index++;
    		   System.out.println("hanghao1:=="+index+"content=="+str);
    		   while (getNumcount(str,";")<len) {
        		   str+=br.readLine().trim().replaceAll("\r", "").replaceAll("\n", "");
        		   index++;
        		   System.out.println("hanghao2:=="+index+"content=="+str);
    			   
    			   /*count++;
        	       System.err.println("写入条数=="+count+"content="+str);
        	       //writeLineFile(filenamenew, str);
        	       writer.write(str+"\r\n");
        	       writer.flush();
        	       str="";*/
        	   }
    		   count++;
    	       System.err.println("写入条数=="+count+"content="+str);
    	       //writeLineFile(filenamenew, str);
    	       writer.write(str+"\r\n");
    	       writer.flush();
    	   }
    	   writer.close();
    	  } catch (FileNotFoundException e) {
    	   System.out.println("找不到指定文件");
    	  } catch (IOException e) {
    	   System.out.println("读取文件失败");
    	  } finally {
	    	   try {
	    	     br.close();
	    	     isr.close();
	    	     fis.close();
	    	    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
	    	   } catch (IOException e) {
	    	    e.printStackTrace();
	    	   }
    	  }
	}
    
    public static int getNumcount(String string, String a)
    {
		int i = string.length() - string.replace(a, "").length();
		return i;
	}
    
    
    public static void writeLineFile(String filename, String content){  
    	try {     
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件     
            FileWriter writer = new FileWriter(filename, true);     
            writer.write(content+"\r\n");     
            writer.close();     
        } catch (IOException e) {     
            e.printStackTrace();     
        } 
    }
}
