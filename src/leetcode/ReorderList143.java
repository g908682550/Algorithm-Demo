package leetcode;

import org.junit.Test;

import java.util.Stack;

public class ReorderList143 {


    @Test
    public void test(){
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        solution2(head);
    }

    public void solution1(ListNode head){
        if(head==null||head.next==null) return;
        ListNode temp=head,tail=head;//temp为头结点遍历指针，tail为中心右节点，即为重排后的最后一个节点
        int length=0;//计算出链表长度
        Stack<ListNode> stack=new Stack<>();//将链表后半部分入栈
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        temp=head;
        for(int i=0;i<(length+1)/2;i++) {
            temp=temp.next;
            if(i==(length+1)/2-2) tail=temp;
        }
        tail.next=null;//防止形成环形链表，尾结点的下一个节点置为null
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        temp=head;
        //进行一个拼接
        ListNode node=null,next=null;
        while(!stack.isEmpty()){
            node=stack.pop();
            next=temp.next;
            temp.next=node;
            node.next=next;
            temp=next;
        }
    }

    /**
     * 找到链表中心节点，拆成两个链表，对后面的链表进行一个反转操作，再进行拼接
     * @param head
     */
    public void solution2(ListNode head){
        if(head==null||head.next==null) return;
        ListNode center=head,quick=head;
        while(quick!=null&&quick.next!=null){
            quick=quick.next;
            quick=quick.next;
            center=center.next;
        }
        ListNode subList=center.next;
        center.next=null;
        subList=reverse(subList);
        merge(head,subList);
    }
    //迭代反转链表
    public ListNode reverse(ListNode node){
        if(node==null||node.next==null) return node;
        ListNode pre=null,next=node.next;
        while(node.next!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        node.next=pre;
        return node;
    }
    //递归反转链表
    public ListNode reverse1(ListNode node){
        if(node==null||node.next==null) return node;
        ListNode p=reverse1(node.next);
        node.next.next=node;
        node.next=null;
        return p;
    }

    public void merge(ListNode l1,ListNode l2){
        ListNode l1next=null,l2next=null;
        while(l2!=null){
            l1next=l1.next;
            l2next=l2.next;
            l1.next=l2;
            l2.next=l1next;
            l2=l2next;
            l1=l1next;
        }
    }

}
