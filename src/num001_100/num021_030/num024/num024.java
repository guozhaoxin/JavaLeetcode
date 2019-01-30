package num001_100.num021_030.num024;

/*
24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

import common.node.ListNode;

public class num024 {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list = new ListNode(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list = s.swapPairs(list);
        list = s.swapPairs(null);
        if(list != null){
            list.print();
        }else {
            System.out.println("empty list");
        }
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead,cur = pre.next,next = cur.next,temp;
        while (cur != null){
            next = cur.next;
            if(next == null){
                break;
            }
            temp = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = temp;
            pre = cur;
            cur = cur.next;
        }
        return newHead.next;
    }
}