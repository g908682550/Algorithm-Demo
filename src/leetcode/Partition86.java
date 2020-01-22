package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Partition86 {


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution1(head,3);
    }

    /**
     * 将小于x的节点放入一个list中，大于x的节点放入另一个list中，然后连接在一起返回
     * @param head
     * @param x
     * @return
     */
    public ListNode solution1(ListNode head, int x){
        List<ListNode> minList=new ArrayList<>();
        List<ListNode> maxList=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x) minList.add(new ListNode(temp.val));
            else maxList.add(new ListNode(temp.val));
            temp=temp.next;
        }
        ListNode result=new ListNode(0);
        ListNode p=result;
        for(ListNode node:minList){
            result.next=node;
            result=result.next;
        }
        for(ListNode node:maxList){
            result.next=node;
            result=result.next;
        }
        return p.next;
    }

    /**
     * 直接创建出两个链表，最后将2个链表连接
     * @param head
     * @param x
     * @return
     */
    public ListNode solution2(ListNode head,int x){
        ListNode min_List=new ListNode(0);
        ListNode min=min_List;
        ListNode max_List=new ListNode(0);
        ListNode max=max_List;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                min.next=temp;
                min=min.next;
            }else{
                max.next=temp;
                max=max.next;
            }
            temp=temp.next;
        }
        min.next=max_List.next;
        max.next=null;
        return min_List.next;
    }

}
