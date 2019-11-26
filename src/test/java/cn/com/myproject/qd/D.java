package cn.com.myproject.qd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D {
    public static void main(String[] args) throws IOException {
        int a=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch ;
        while ((a = br.read()) != -1) {
            ch = (char) a;
            System.out.print(ch);
        }

    }


}
