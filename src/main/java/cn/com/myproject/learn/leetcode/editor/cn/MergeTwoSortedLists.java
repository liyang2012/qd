//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics 链表

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class MergeTwoSortedLists{
    public static void main(String[] args) {
       Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        /**
         * 递归
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) {
                return l2;
            }else if (l2 == null) {
                return l1;
            }else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }else{
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }

        /**
         * 迭代
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1);

            ListNode prev = head;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 == null ? l2 : l1;

            return head.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}