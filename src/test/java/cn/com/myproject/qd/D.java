package cn.com.myproject.qd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        D d = new D();
        d.s(1);
        System.out.println("-------------");
        d.s(0);

    }

    private void s(int i) {
        if (i == 1) {
            System.out.println("1");
            return;
        }
        System.out.println("==");
    }

}
