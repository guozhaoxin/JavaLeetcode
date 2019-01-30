package num001_100.num021_030.num023;

/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */

import common.node.ListNode;

import java.util.HashMap;
import java.util.Iterator;

public class num023 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(4);
        l1.add(5);
        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(4);
        ListNode l3 = new ListNode(2);
        l3.add(6);
        ListNode[] lists = new ListNode[]{l1,l2,l3};
        ListNode res = new Solution().mergeKLists(lists);
        res.print();
    }
}



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        HashMap<ListNode,ListNode> map = new HashMap<>();
        for(ListNode cur : lists){
            if(cur != null){
                map.put(cur,cur);
            }
        }
        while (map.size() > 1){
            Iterator iterator = map.keySet().iterator();
            int small = Integer.MAX_VALUE;
            ListNode smallListNode = null;
            while (iterator.hasNext()){
                ListNode temp = null;
                temp = (ListNode) iterator.next();
                if(small >= map.get(temp).val){
                    small = map.get(temp).val;
                    smallListNode = temp;
                }
            }
            ListNode next = new ListNode(small);
            pre.next = next;
            pre = next;
            if(map.get(smallListNode).next == null){
                map.remove(smallListNode);
            }else {
                map.put(smallListNode,map.get(smallListNode).next);
            }
        }
        if(map.size() == 1){
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                pre.next = map.get(iterator.next());
            }
        }
        return head.next;
    }

}