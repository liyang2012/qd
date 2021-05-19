//You are given a data structure of employee information, which includes the emp
//loyee's unique id, their importance value and their direct subordinates' id. 
//
// For example, employee 1 is the leader of employee 2, and employee 2 is the le
//ader of employee 3. They have importance value 15, 10 and 5, respectively. Then 
//employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3
//]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subor
//dinate of employee 1, the relationship is not direct. 
//
// Now given the employee information of a company, and an employee id, you need
// to return the total importance value of this employee and all their subordinate
//s. 
//
// Example 1: 
//
// 
//Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//Output: 11
//Explanation:
//Employee 1 has importance value 5, and he has two direct subordinates: employe
//e 2 and employee 3. They both have importance value 3. So the total importance v
//alue of employee 1 is 5 + 3 + 3 = 11.
// 
//
// 
//
// Note: 
//
// 
// One employee has at most one direct leader and may have several subordinates.
// 
// The maximum number of employees won't exceed 2000. 
// 
// Related Topics 深度优先搜索 广度优先搜索 哈希表 
// 👍 198 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance{
    public static void main(String[] args) {
        Solution solution = new EmployeeImportance().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    */

    class Solution {
        Map<Integer, Employee> map = new HashMap();
        public int getImportance(List<Employee> employees, int id) {
            for (Employee e : employees) {
                map.put(e.id, e);
            }

            return dfs(id);
        }
        private int dfs(int id) {
            if (map.containsKey(id)) {
                int sum = map.get(id).importance;
                for (Integer i : map.get(id).subordinates) {
                    sum += dfs(i);
                }
                return sum;
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;


    }
}