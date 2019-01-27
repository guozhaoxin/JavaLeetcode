package common.node;

public class ListNode {
      int val;
      ListNode next;
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

}