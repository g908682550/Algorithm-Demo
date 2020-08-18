package leetcode;

import org.junit.Test;

public class IsPalindrome234 {

    @Test
    public void test(){
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node3=new ListNode(1);
        head.next=node1;
        node1.next=node3;
//        node2.next=node3;
        solution1(head);
    }

    /**
     * 取中心节点，对后半部分反转后再进行判断
     * @param head
     * @return
     */
    public boolean solution1(ListNode head){
        ListNode slow=head,quick=head;
        while(quick!=null&&quick.next!=null){
            quick=quick.next;
            quick=quick.next;
            slow=slow.next;
        }
        slow=reverse(slow);
        return helper(slow,head);
    }

    public ListNode reverse(ListNode node){
        if(node==null||node.next==null) return node;
        ListNode next=null,pre=null;
        while(node.next!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        node.next=pre;
        return node;
    }

    public boolean helper(ListNode node1,ListNode node2){
        while(node1!=null&&node2!=null){
            if(node1.val!=node2.val) return false;
            node1=node1.next;
            node2=node2.next;
        }
        return true;
    }

}
