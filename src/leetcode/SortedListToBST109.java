package leetcode;

import org.junit.Test;

public class SortedListToBST109 {

    @Test
    public void test(){
        ListNode root=new ListNode(-10);
        ListNode node1=new ListNode(-3);
        ListNode node2=new ListNode(-0);
        ListNode node3=new ListNode(5);
        ListNode node4=new ListNode(9);
        root.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        TreeNode treeNode = solution(root);
        System.out.println(treeNode);
    }

    public TreeNode solution(ListNode head){
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow=head,quick=head,pre=null;
        while(quick!=null&&quick.next!=null){
            pre=slow;
            slow=slow.next;
            quick=quick.next.next;
        }
        pre.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=solution(head);
        root.right=solution(slow.next);
        return root;
    }

}
