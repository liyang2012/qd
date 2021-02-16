//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics 堆 链表 分治算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MergeKSortedLists{
    public static void main(String[] args) {
       Solution solution = new MergeKSortedLists().new Solution();
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
         * 优先队列
         * @param lists
         * @return
         */
        public ListNode mergeKLists1(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            PriorityQueue<ListNode> queue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> (o1.val - o2.val));
            for (ListNode node : lists) {
                while (node != null) {
                    queue.add(node);
                    node = node.next;
                }
            }
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while (!queue.isEmpty()) {
                dummy.next  = queue.poll();
                dummy = dummy.next;
            }
            dummy.next = null;
            return head.next;
        }

        /**
         * 优化堆
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0) {
                return null;
            }
            //创建一个小根堆，并定义好排序函数
            PriorityQueue<ListNode> queue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> (o1.val - o2.val));

            //这里跟上一版不一样，不再是一股脑全部放到堆中
            //而是只把k个链表的第一个节点放入到堆中
            for(ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }

            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            //之后不断从堆中取出节点，如果这个节点还有下一个节点，
            //就将下个节点也放入堆中
            while(!queue.isEmpty()) {
                ListNode node = queue.poll();
                cur.next = node;
                cur = cur.next;
                if(node.next!=null) {
                    queue.add(node.next);
                }
            }
            cur.next = null;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}