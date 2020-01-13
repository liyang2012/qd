package cn.com.myproject.qd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {

       String str = "{\"code\":\"error\",\"msg\":\"\\u914d\\u989d\\u79ef\\u5206\\u4e0d\\u8db3\"}";

        System.out.println(str.contains("\\u914d\\u989d\\u79ef\\u5206\\u4e0d\\u8db3"));

    }

}
