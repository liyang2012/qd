//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics 链表

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ReverseNodesInKGroup{
    public static void main(String[] args) {
       Solution solution = new ReverseNodesInKGroup().new Solution();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode  = solution.reverseKGroup(listNode,2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tail = head;
            for(int i = 0; i < k; i++) {
                if(tail == null) {
                    return head;
                }
                tail = tail.next;
            }
            //反转前K个元素
            ListNode newHead = reverse(head, tail);
            head.next = reverseKGroup(tail, k);
            return newHead;

        }

        private ListNode reverse(ListNode head,ListNode tail) {
            ListNode pre = null;
            ListNode curr = null;
            while (head != tail) {
                curr = head.next;
                head.next = pre;

                pre = head;
                head = curr;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}