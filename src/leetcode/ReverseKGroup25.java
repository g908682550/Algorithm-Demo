package leetcode;

import org.junit.Test;

public class ReverseKGroup25 {

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

    public ListNode solution1(ListNode head, int k){
        if(head==null) return head;
        ListNode temp=head;
        int count=k;//对k进行保存，防止污染
        while(count>1) {
            temp = temp.next;//将temp移动到要反转的k个链表的最后一个位置
            count--;
            if (temp == null) return head;//如果不够k个，直接返回，不用反转
        }
        ListNode first=head,second=temp;//first为局部反转链表的第一个，second为局部反转链表的第二个
        ListNode next=second.next;//保存一下下一个要反转链表的开始
        reverse(first,second);//对局部链表进行反转
        first.next=solution1(next,k);//方法返回的是后面已经反转完成的头节点，将其连接即可
        return second;//最后将头结点返回
    }
    //迭代反转链表的方法
    public void reverse(ListNode first,ListNode second){
        ListNode temp=first,next=null,pre=null;
        while(temp!=second){
            next=temp.next;
            temp.next=pre;
            pre=temp;
            temp=next;
        }
        temp.next=pre;
    }

    //递归反转链表
    public ListNode reverse1(ListNode head,ListNode tail){
        if(head==tail) return head;
        ListNode p=reverse1(head.next,tail);
        head.next.next=head;
        head.next=null;
        return p;
    }
}
