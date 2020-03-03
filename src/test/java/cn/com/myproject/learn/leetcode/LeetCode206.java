package cn.com.myproject.learn.leetcode;

/**
 * 反向链表
 * */
public class LeetCode206 {
    /**
     * 迭代
     * */
    public static ListNode reverseList(ListNode head) {
        ListNode l = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = l;
            l = curr;
            curr = nextTemp;
        }
        return l;
    }
    /**
     * 递归
     * */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = reverseList1(head);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode  = listNode.next;
        }
    }
}
