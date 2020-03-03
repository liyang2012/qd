package cn.com.myproject.learn.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转换整数 (atoi)
 * */
public class LeetCode8 {
    public static int myAtoi(String str) {
        int rev = 0;
        char[] charList = str.toCharArray();
        int length = str.length();
        int zf = 1;
        int i = 0;
        int pop = 0;
        for(;  i < length; i++){
            if(charList[i] == ' '){
                continue;
            }else{
                if(charList[i] == '-'){
                    i++;
                    zf = -1;
                    break;
                }
                if(charList[i] == '+'){
                    i++;
                    break;
                }
                if(charList[i] <'0' || charList[i] >'9'){
                    return 0;
                }else{
                    break;
                }
            }
        }
        if(i == length){
            return 0;
        }
        for(;i < length; i++){
            if(charList[i] <'0' || charList[i] >'9'){
                return rev;
            }
            pop = (charList[i] -48) * zf;
            if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                return Integer.MAX_VALUE;
            }
            if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return Integer.MIN_VALUE;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int myAtoi1(String str) {
        //清空字符串开头和末尾空格（这是trim方法功能，事实上我们只需清空开头空格）
        str = str.trim();
        //java正则表达式
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;
        //判断是否能匹配
        if (m.find()){
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e){
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        String str = "  -120981039";
        System.out.println(myAtoi(str));
        System.out.println(myAtoi1(str));
    }
}
