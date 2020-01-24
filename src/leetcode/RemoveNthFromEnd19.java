package leetcode;

import org.junit.Test;

public class RemoveNthFromEnd19 {


    @Test
    public void test(){
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        solution1(head,2);
    }


    public ListNode solution1(ListNode head, int n){
        if(head==null||head.next==null) return null;
        ListNode preNode=new ListNode(0),pre=preNode;
        preNode.next=head;
        ListNode quick=head;
        while(n>0&&quick!=null){
            quick=quick.next;
            n--;
        }
        while(quick!=null){
            quick=quick.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return preNode.next;
    }

}
