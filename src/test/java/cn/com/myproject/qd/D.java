package cn.com.myproject.qd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {

        System.out.println("=====");

    }
    void v1() {
        for(int i=0;i<1000;i++) {
            System.out.println("+");
        }
    }

    void v2() {
        int[] i = new int[1000];
        i[0] = 0;
        for(int j:i) {
            System.out.println("+");
        }
    }

    void v3() {
        int i = 1;
        while(i<1000){
            System.out.println("-");
            i++;
        }
    }

    void v4( List<Integer> list) {
        Iterator<Integer> it =  list.iterator();
        while (it.hasNext()){
            Integer num = it.next();
            if (num == 11){
                it.remove();
            }else{
                System.out.println(num);
            }
        }
    }
    void v5( List<Integer> list) {
        for(Integer num:list){
            if (num == 11){
                list.remove(num);
            }else{
                System.out.println(num);
            }
        }
    }
}
