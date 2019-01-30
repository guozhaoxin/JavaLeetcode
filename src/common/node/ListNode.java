package common.node;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) {
          this.val = x;
      }

      public void print(){
          ListNode temp = this;
          while (temp != null){
              System.out.print(temp.val);
              System.out.print('\t');
              temp = temp.next;
          }
      }

      public void add(int num){
        ListNode pre = this;
        while (pre.next != null){
            pre = pre.next;
        }
        pre.next = new ListNode(num);
      }

}