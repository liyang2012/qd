package cn.com.myproject.learn.leetcodem;


/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内
 *
 * */
public class LeetCodeM0106 {
    public static String compressString(String s) {
        if(null == s || s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder().append(arr[0]);

        int k = 1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i] == arr[i-1]) {
                k++;
            }else{
                sb.append(k).append(arr[i]);
                k = 1;
            }
        }
        return sb.append(k).length()<s.length()?sb.toString():s;
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compressString(str));
    }
}
