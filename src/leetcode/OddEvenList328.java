package leetcode;

import org.junit.Test;

public class OddEvenList328 {


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
        ListNode node = solution1(head);
        ListNode.printLink(node);
    }


    public ListNode solution1(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode odd_List=head,even_List=head.next,odd=odd_List,even=even_List;//将第一个奇数节点和第一个偶数节点保存,odd和even分别构建出奇数链表和偶数链表
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=even_List;//将奇数链表的下一个节点指向偶数链表的第一个
        return odd_List;
    }

}
