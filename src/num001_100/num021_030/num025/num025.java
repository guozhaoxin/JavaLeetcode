package num001_100.num021_030.num025;

/*
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

import common.node.ListNode;

public class num025 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.print();
        Solution s = new Solution();
        ListNode res = s.reverseKGroup(head,1);
        res.print();
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        int steps;
        ListNode temp,pre = tempHead,cur = head,next;
        while (cur != null){
            temp = cur;
            for(steps = 1;steps < k;steps++){
                temp = temp.next;
                if(temp == null){
                    break;
                }
            }
            if(temp == null){
                break;
            }
            next = temp.next;
            this.swap(cur,temp);
            pre.next = temp;
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return tempHead.next;
    }

    private ListNode[] swap(ListNode start,ListNode end){
        ListNode pre,cur,next,flag = end.next;
        cur = start.next;
        pre = start;
        while (cur != flag){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{end,start};
    }
}