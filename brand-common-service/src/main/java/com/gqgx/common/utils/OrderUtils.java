package com.gqgx.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String newOrderCode() {
        String code = sdf.format(new Date());
        code += twoRondom();
        return code;
    }

    public static void main(String[] args) {
        System.out.println(newOrderCode());
    }

    public static int twoRondom() {
        return (int) (Math.random() * 90 + 10);
    }
}
