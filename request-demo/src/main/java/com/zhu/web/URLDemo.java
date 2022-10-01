package com.zhu.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "一二";

        String encode = URLEncoder.encode(username, "utf-8");
        System.out.println(encode);

        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode);

        // to byte
        byte[] bytes = decode.getBytes("ISO-8859-1");
        /*  for (byte b:bytes) {
            System.out.print(b + " ");
        }*/

        // byte to string
        String s = new String(bytes, "utf-8");
        System.out.println(s);

    }
}
