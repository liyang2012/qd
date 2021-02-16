//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics 字符串 回溯算法 
// 👍 889 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> list = solution.letterCombinations("23");
        System.out.println(list.toString());

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Map<Character, String> phoneMap =new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return combinations;
            }
            backtrack(combinations, digits, 0, new StringBuffer());
            return combinations;
        }

        private void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}