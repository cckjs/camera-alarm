package com.young.java.util.base64;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by Administrator on 2015/12/30.
 */
public class Base64Tool {

    private static Base64 base64 = new Base64();

    public static String encode(String line) {
        byte[] bytes = line.getBytes();
        return new String(base64.encode(bytes));
    }

    public static String decode(String line) {
        byte[] bytes = base64.decode(line.getBytes());
        return new String(bytes);
    }

    public static void main(String[] args) {
        System.out.println(Base64Tool.encode("yangyong"));
        System.out.println(Base64Tool.decode("eWFuZ3lvbmc="));
    }
}
