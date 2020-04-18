//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics 链表

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ReverseLinkedList{
    public static void main(String[] args) {
       Solution solution = new ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            ListNode l = null;
            ListNode curr = head;
            while(curr != null) {
                //记录当前节点的下一个节点
                ListNode nextTemp = curr.next;
                //然后将当前节点指向pre
                curr.next = l;
                //pre和cur节点都前进一位
                l = curr;
                curr = nextTemp;
            }
            return l;
        }

        public ListNode reverseList1(ListNode head) {
            //递归终止条件是当前为空，或者下一个节点为空
            if(head==null || head.next==null) {
                return head;
            }
            //这里的cur就是最后一个节点
            ListNode cur = reverseList1(head.next);
            //这里请配合动画演示理解
            //如果链表是 1->2->3->4->5，那么此时的cur就是5
            //而head是4，head的下一个是5，下下一个是空
            //所以head.next.next 就是5->4
            head.next.next = head;
            //防止链表循环，需要将head.next设置为空
            head.next = null;
            //每层递归函数都返回cur，也就是最后一个节点
            return cur;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
    }
}