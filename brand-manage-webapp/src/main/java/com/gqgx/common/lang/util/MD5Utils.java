package com.gqgx.common.lang.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {

    public static final String KEY_MD5 = "MD5";

    public static String encryptMD5(String plainText) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();


            for (int offset = 0; offset < b.length; offset++) {
                int i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }


    public static String encryptMD5(byte[] bytes) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] b = md.digest();

            for (int offset = 0; offset < b.length; offset++) {
                int i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
}
