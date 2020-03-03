package cn.com.myproject.learn.leetcode;

/**
 *
 * */
public class LeetCode38 {
    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        if(n == 2) {
            return "11";
        }
        StringBuilder result = new StringBuilder("11");
        String  str = "11";
        int len;
        char c;
        int k;
        for(int i=3;i<=n;i++ ) {
            c = result.charAt(0);
            k = 1;
            str = result.toString();
            len = str.length();
            result = new StringBuilder();
            for(int j=1;j<len;j++){
                if(str.charAt(j) == c){
                    k++;
                }else{
                    result.append(k).append(c);
                    c = str.charAt(j);
                    k = 1;
                }
                if(j == len-1) {
                    result.append(k).append(c);
                    break;
                }

            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        for(int i=1;i<=30;i++) {
            System.out.println(countAndSay(i));
        }

    }
}
