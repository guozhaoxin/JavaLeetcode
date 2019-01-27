package num001_100.num021_030;

/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */


import java.util.HashMap;
import java.util.Iterator;

public class num021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2);
        l1.add(4);
        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(4);
        l1.print();
        l2.print();
        ListNode l3 = new ListNode(5);
        l3.add(7);
        l3.add(8);
        l3.add(9);
        ListNode res = new Solution().mergeTwoLists(l1,l2);
        System.out.println();
        res.print();
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     boolean add(int num){
         ListNode pre = this;
         while (pre.next != null){
             pre = pre.next;
         }
         pre.next = new ListNode(num);
         return true;
     }

    void print(){
        ListNode temp = this;
        while (temp != null){
            System.out.print(temp.val);
            System.out.print('\t');
            temp = temp.next;
        }
    }
 }

class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode pre = head;
        HashMap<ListNode,ListNode> map = new HashMap<>();
        map.put(l1,l1);
        map.put(l2,l2);
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null){
            pre.next = l1;
        }
        if(l2 != null){
            pre.next = l2;
        }
        return head.next;
    }
}