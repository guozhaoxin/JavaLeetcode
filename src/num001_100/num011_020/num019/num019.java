package num001_100.num011_020.num019;

/*
19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
 */


public class num019 {
    public static void main(String[] args) {
        ListNode pre = new ListNode(1);
        ListNode head = pre;
        int num = 2;
        while (num <= 5){
            ListNode temp = new ListNode(num);
            pre.next = temp;
            pre = temp;
            num++;
        }
        head.print();
        Solution s = new Solution();
        head = s.removeNthFromEnd(head,2);
        head.print();
    }
}



 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public void print(){
          ListNode temp = this;
          while (temp != null){
              System.out.println(temp.val);
              temp = temp.next;
          }
      }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head,slow;
        int k = 0;
        while (k < n){
            fast = fast.next;
            k++;
        }
        slow = head;
        ListNode pre = null;
        while (fast != null){
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if(pre == null){
            return slow.next;
        }else {
            pre.next = slow.next;
            return head;
        }
    }
}