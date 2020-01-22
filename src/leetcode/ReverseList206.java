package leetcode;

import org.junit.Test;

public class ReverseList206 {


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
        head=solution3(head);
        ListNode.printLink(head);
    }


    /**
     * 双指针遍历反转链表
     * @return
     */
    public ListNode solution1(ListNode head){
            if(head==null) return null;
            ListNode pre=null,next=null,temp=head;
            while(temp.next!=null){
                next=temp.next;
                temp.next=pre;
                pre=temp;
                temp=next;
            }
            temp.next=pre;
            return temp;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode p=solution2(head.next);//p结点为最深处节点
        head.next.next=head;
        head.next=null;
        return p;
    }

    /**
     * 仍然是递归解法，对尾结点进行一个保存
     * @param head
     * @return
     */
    public ListNode solution3(ListNode head){
        if(head==null) return null;
        ListNode temp=head,tail=temp;
        while(temp.next!=null){//保存一下尾结点
            temp=temp.next;
            tail=temp;
        }
        helper(head);//对链表进行反转
        return tail;
    }

    public ListNode helper(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode p=helper(head.next);
        p.next=head;
        head.next=null;
        return head;
    }
}

