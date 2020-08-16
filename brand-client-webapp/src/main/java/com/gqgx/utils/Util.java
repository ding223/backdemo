package com.gqgx.utils;

import java.util.Map;

public class Util {
	/** 
     * 字符转码 
     * @param theString 
     * @return 
     */  
    public static String decodeUnicode(String theString){  
          
        char aChar;  
          
        int len = theString.length();  
          
        StringBuffer buffer = new StringBuffer(len);  
          
        for (int i = 0; i < len;) {  
              
            aChar = theString.charAt(i++);  
              
            if(aChar == '\\'){  
                  
                aChar = theString.charAt(i++);  
              
                if(aChar == 'u'){  
                      
                    int val = 0;  
                      
                    for(int j = 0; j < 4; j++){  
                          
                        aChar = theString.charAt(i++);  
                          
                        switch (aChar) {  
                          
                        case '0':  
                              
                        case '1':  
                              
                        case '2':  
                              
                        case '3':  
                              
                        case '4':  
                          
                        case '5':  
                              
                        case '6':  
                          
                        case '7':  
                              
                        case '8':  
                              
                        case '9':  
                              
                        val = (val << 4) + aChar - '0';  
                          
                        break;  
      
                        case 'a':  
                              
                        case 'b':  
                              
                        case 'c':  
                              
                        case 'd':  
                              
                        case 'e':  
                              
                        case 'f':  
                              
                        val = (val << 4) + 10 + aChar - 'a';  
                                 
                        break;  
                          
                        case 'A':  
                              
                        case 'B':  
                              
                        case 'C':  
                              
                        case 'D':  
                              
                        case 'E':  
                              
                        case 'F':  
                            
                        val = (val << 4) + 10 + aChar - 'A';  
                                 
                        break;  
                                 
                        default:  
                          
                        throw new IllegalArgumentException(  
                               
                            "Malformed      encoding.");  
                        }  
                          
                    }  
                      
                    buffer.append((char) val);  
                      
                    }else{  
                          
                        if(aChar == 't'){  
                              
                            aChar = '\t';  
                        }  
                          
                        if(aChar == 'r'){  
                              
                            aChar = '\r';  
                        }  
                          
                        if(aChar == 'n'){  
                              
                            aChar = '\n';  
                        }  
                          
                        if(aChar == 'f'){  
                              
                            aChar = '\f';  
                              
                        }  
                          
                        buffer.append(aChar);  
                    }  
                  
                }else{  
                      
                    buffer.append(aChar);  
                      
                }  
                  
            }  
          
        return buffer.toString();  
          
    }  
    
    public static String str2HexStr(byte [] bs) {  
        char[] chars = "0123456789ABCDEF".toCharArray();  
        StringBuilder sb = new StringBuilder("");
        int bit;  
        for (int i = 0; i < bs.length; i++) {  
            bit = (bs[i] & 0x0f0) >> 4;  
            sb.append(chars[bit]);  
            bit = bs[i] & 0x0f;  
            sb.append(chars[bit]);  
        }  
        return sb.toString();  
    } 
    
    
    /**
     * 把16进制字符串转换成字节数组
     * @param hex
     * @return byte[]
     */
    public static byte[] hexStringToByte(String hex) {
     int len = (hex.length() / 2);
     byte[] result = new byte[len];
     char[] achar = hex.toCharArray();
     for (int i = 0; i < len; i++) {
      int pos = i * 2;
      result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
     }
     return result;
    }
    
    private static int toByte(char c) {
       byte b = (byte) "0123456789ABCDEF".indexOf(c);
       return b;
    }
    

    private static void JsonToHashMap(String key, Object value, Map<Object, Object> rstList) {  
        rstList.put(key, value);  
    }  
    
    public static String escape(String str) {
    	return str.replaceAll("%", "%3D")
    	  		 .replaceAll("&", "%26")
    			 .replaceAll(" ", "%20")
    			 .replaceAll("\\?", "%3F")
    			 .replaceAll("\\|", "%124")
    			 .replaceAll("=", "%3D")
    			 .replaceAll("#", "%3D")
    			 .replaceAll("/", "%3D")
    			 .replaceAll("\\+", "%3D");
    }
}
