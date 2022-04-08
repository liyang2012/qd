package cn.com.myproject.learn.leetcode;

/**
 *
 * */
public class LeetCode1160 {
    public  static int countCharacters(String[] words, String chars) {
        int[] c = new int[26];
        //26个字母出现的次数
        for(char cc : chars.toCharArray()) {
            c[(int)(cc - 'a')] += 1;
        }
        int res = 0;

        for(String word : words) {
            boolean b = true;
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[(int)(ww - 'a')] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    b = false;
                    break;
                }
            }
            if(b) {
                res += word.length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] w = {"hello","world","leetcode"};
        System.out.println(countCharacters(w,"welldonehoneyr"));
    }
}
