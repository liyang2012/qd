package cn.com.myproject.qd;

import java.util.HashSet;
import java.util.Set;

public class D {
    public static void main(String[] args) {
        D d = new D();
        String str = d.longestCommonPrefix(new String[]{"c","c","c"});
        System.out.println(str);

    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) {
            return "";
        }
        if(strs.length==1) {
            return strs[0];
        }
        String str1 = "",str2="";
        for(int i=0;i<strs[0].length();i++) {
            str2 = strs[0].substring(0,strs[0].length()-i);
            if(c(str2,strs)) {
                str1 = str2;
            }else{
                break;
            }
        }
        return str1;
    }
    boolean c(String str,String[] strs) {
        for(int j=1;j<strs.length;j++) {
            if(!strs[j].startsWith(str)) {
                return false;
            }
        }
        return true;
    }


}
