package leetcode;

import org.junit.Test;

public class ReverseBetween92 {

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
        ListNode node=solution2(head,2,4);
        ListNode.printLink(node);
    }

    /**
     * 遍历方法从m到n反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode solution1(ListNode head, int m, int n){
        ListNode res=new ListNode(0);
        res.next=head;
        ListNode node=res;
        for(int i=1;i<m;i++) node=node.next;//找到链表反转节点的前一个节点
        ListNode pre=null,next=null,temp=node.next;
        for(int i=0;i<=n-m;i++){
            next=temp.next;
            temp.next=pre;
            pre=temp;
            temp=next;
        }
        node.next.next=temp;
        node.next=pre;
        return res.next;
    }

    /**
     * 递归解题
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode solution2(ListNode head, int m, int n){
        ListNode res=new ListNode(0);
        res.next=head;
        ListNode node=res;
        for(int i=1;i<m;i++) node=node.next;//找到链表反转节点的前一个节点
        ListNode temp=node.next;//保存反转的第一个节点
        ListNode tail=temp;//
        for(int i=0;i<=n-m;i++) tail=tail.next;//保存反转后的下一个节点
        node.next=helper(node.next,0,n-m);//第一个节点为反转后的第一个节点
        temp.next=tail;
        return res.next;
    }

    /**
     * 递归的从当前节点往后反转n-m个
     * @param node
     * @param height
     * @param length
     * @return
     */
    public ListNode helper(ListNode node,int height,int length){
        if(node==null||node.next==null||height==length) return node;
        ListNode p=helper(node.next,height+1,length);
        node.next.next=node;
        node.next=null;
        return p;
    }


}
