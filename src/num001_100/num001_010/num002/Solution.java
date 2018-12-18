package num001_100.num001_010.num002;

//import common.node.ListNode;

/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }

    ListNode add(int val){
        if(this == null){
            return new ListNode(val);
        }
        ListNode temp = this;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return this;
    }

    void print(){
        ListNode temp = this;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.add(4);
        l1.add(3);
        ListNode l2 = new ListNode(5);
        l2.add(6);
        l2.add(4);
        Solution s = new Solution();
        ListNode res = s.addTwoNumbers(l1,l2);
        res.print();
        res = s.addTwoNumbers(new ListNode(5),new ListNode(5));
        res.print();
        l1 = new ListNode(9);
        l1.add(8);
        l2 = new ListNode(1);
        res = s.addTwoNumbers(l1,l2);
        System.out.println("*****");
        res.print();
        l1 = new ListNode(1);
        l2 = new ListNode(9);
        l2.add(9);
        res = s.addTwoNumbers(l1,l2);
        res.print();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode l1Cur = l1;
        ListNode l2Cur = l2;

        ListNode result = new ListNode((l1Cur.val + l2Cur.val) % 10);
        ListNode previous = result;
        ListNode cur = null;
        int add = (l1Cur.val + l2Cur.val) / 10;
        l1Cur = l1Cur.next;
        l2Cur = l2Cur.next;
        int val = 0;
        while (l1Cur != null && l2Cur != null){
                val = l1Cur.val + l2Cur.val + add;
                cur = new ListNode(val % 10);
                add = val / 10;
                previous.next = cur;
                previous = cur;
                l1Cur = l1Cur.next;
                l2Cur = l2Cur.next;
        }

        if(l1Cur != null){
            if(add == 0){
                previous.next = l1Cur;
            }
            else {
                while (add != 0 && l1Cur != null){
                    val = add + l1Cur.val;
                    cur = new ListNode(val % 10);
                    add = val / 10;
                    previous.next = cur;
                    previous = cur;
                    l1Cur = l1Cur.next;
                }
                if (l1Cur != null){
                    previous.next = l1Cur;
                }
                else if(add != 0){
                    previous.next = new ListNode(add);
                    add = 0;
                }
            }
        }
        if(l2Cur != null){
            if(add == 0){
                previous.next = l2Cur;
            }
            else {
                while (add != 0 && l2Cur != null){
                    val = add + l2Cur.val;
                    cur = new ListNode(val % 10);
                    add = val / 10;
                    previous.next = cur;
                    previous = cur;
                    l2Cur = l2Cur.next;
                }
                if (l2Cur != null){
                    previous.next = l2Cur;
                }
                else if(add != 0){
                    previous.next = new ListNode(1);
                    add = 0;
                }
            }
        }
        if(add != 0){
            previous.next = new ListNode(1);
        }

        return result;
    }

}