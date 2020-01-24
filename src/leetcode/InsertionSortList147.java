package leetcode;

import org.junit.Test;

public class InsertionSortList147 {

    @Test
    public void test(){
        ListNode head=new ListNode(-1);
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(0);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        solution1(head);
    }


    public ListNode solution1(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode result=new ListNode(0);
        ListNode pre=result;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            while(pre.next!=null&&pre.next.val<curr.val){
                pre=pre.next;
            }
            curr.next=pre.next;
            pre.next=curr;
            pre=result;
            curr=next;
        }
        return result.next;
    }


}
