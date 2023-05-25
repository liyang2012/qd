package cn.com.myproject.qd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import cn.com.myproject.qd.model.User;

public class D {
    public static void main(String[] args) throws IOException {
        int ii = 1;
        System.out.println(Integer.toBinaryString(ii));
        System.out.println(Integer.toBinaryString(ii << 64));
        User user = new User();


        List<Integer> list = new ArrayList<Integer>(){{add(1); add(2); add(3); add(4);}};

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
            }
        }

        try {
            for (int i : list) {
                if (i == 3) {
                    list.remove(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Singleton1 singleton1 = Singleton1.INSTANCE;
    }



}
