//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics 链表

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SwapNodesInPairs{
    public static void main(String[] args) {

        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = solution.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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
        public ListNode swapPairs1(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode f = head;
            ListNode s = head.next;
            f.next = swapPairs1(s.next);
            s.next = f;

            return s;
        }
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode prevNode  = dummy;

            while(head != null && head.next != null) {
                ListNode f = head;
                ListNode s = head.next;

                prevNode.next = s;
                f.next = s.next;
                s.next = f;

                prevNode = f;
                head = f.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}