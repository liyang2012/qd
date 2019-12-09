package cn.com.myproject.qd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D {
    public static void main(String[] args) throws IOException {
      for(int i=0;i<10;i++) {
          System.out.println("i:"+i);
          for(int j=0;j<20;j++) {
              System.out.println("j:"+j);
              if(j==5) {
                  break;
              }
          }
      }
    }


}
