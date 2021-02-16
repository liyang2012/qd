//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics 哈希表 字符串

  
package cn.com.myproject.learn.leetcode.editor.cn;


import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
       String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
       List<List<String>> list = solution.groupAnagrams(strs);
        System.out.println(list.toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> ans = new HashMap<>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if (!ans.containsKey(key)) {
                    ans.put(key, new ArrayList<>());
                }
                ans.get(key).add(s);
            }
            return new ArrayList<>(ans.values());
        }

        /***
         * 计数
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams1s(String[] strs) {
            if(strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> ans = new HashMap<>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) {
                    count[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    sb.append("#").append(count[i]);
                }
                String key = sb.toString();
                if (! ans.containsKey(key)) {
                    ans.put(key, new ArrayList<>());
                }
                ans.get(key).add(s);
            }
            return new ArrayList<>(ans.values());
        }
        /**
         * 质数相乘
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams2(String[] strs) {
            HashMap<Integer, List<String>> hash = new HashMap<>();
            //每个字母对应一个质数
            int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
            for (int i = 0; i < strs.length; i++) {
                int key = 1;
                //累乘得到 key
                for (int j = 0; j < strs[i].length(); j++) {
                    key *= prime[strs[i].charAt(j) - 'a'];
                }
                if (hash.containsKey(key)) {
                    hash.get(key).add(strs[i]);
                } else {
                    List<String> temp = new ArrayList<String>();
                    temp.add(strs[i]);
                    hash.put(key, temp);
                }

            }
            return new ArrayList<>(hash.values());
        }
    }



    //leetcode submit region end(Prohibit modification and deletion)

}