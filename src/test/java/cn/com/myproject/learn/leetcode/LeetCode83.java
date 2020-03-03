package cn.com.myproject.learn.leetcode;

/**
 * 删除排序链表中的重复元素
 * */
public class LeetCode83 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null &&  curr.next != null) {
            if(curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        node1.next.next =  new ListNode(2);
        ListNode listNode = deleteDuplicates(node1);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}

