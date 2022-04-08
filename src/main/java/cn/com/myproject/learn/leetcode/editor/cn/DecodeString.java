//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; No extra white spaces, 
//square brackets are well-formed, etc. 
//
// Furthermore, you may assume that the original data does not contain any digit
//s and that digits are only for those repeat numbers, k. For example, there won't
// be input like 3a or 2[4]. 
//
// Examples: 
//
// 
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
// 
//
// 
// Related Topics 栈 深度优先搜索

  
package cn.com.myproject.learn.leetcode.editor.cn;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DecodeString{
    public static void main(String[] args) {
       Solution solution = new DecodeString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ptr = 0;
        public String decodeString(String s) {
            LinkedList<String> list = new LinkedList<>();

            while (ptr < s.length()) {
                char cur = s.charAt(ptr);
                if (Character.isDigit(cur)) {
                    String digits = getDigits(s);
                    list.add(digits);
                } else if (Character.isLetter(cur) || cur == '[') {
                    list.add(String.valueOf(s.charAt(ptr++)));
                } else {
                    ++ptr;
                    LinkedList<String> sub = new LinkedList<>();
                    while (!"[".equals(list.peekLast())) {
                        sub.addLast(list.removeLast());
                    }
                    Collections.reverse(sub);
                    //左括号出
                    list.removeLast();
                    int repTime = Integer.parseInt(list.removeLast());
                    StringBuilder sb = new StringBuilder();
                    String o = getString(sub);
                    while (repTime-- > 0) {
                        sb.append(o);
                    }

                    list.addLast(sb.toString());
                }
            }
            return getString(list);
        }
        public String getDigits(String s) {
            StringBuffer ret = new StringBuffer();
            while (Character.isDigit(s.charAt(ptr))) {
                ret.append(s.charAt(ptr++));
            }
            return ret.toString();
        }

        public String getString(LinkedList<String> v) {
            StringBuffer ret = new StringBuffer();
            for (String s : v) {
                ret.append(s);
            }
            return ret.toString();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}