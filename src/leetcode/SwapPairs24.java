package leetcode;

public class SwapPairs24 {


    /**
     * 建立3个指针进行迭代
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode result=new ListNode(0),temp=result,quick=head.next,slow=head,pre=result;
        result.next=head;
        //第一个节点和第二个节点为交换的节点，前一个节点为第一个节点之前的节点
        while(quick!=null){
            slow.next=quick.next;//将第三个节点保存
            quick.next=slow;//第二个节点的下一个节点指向第一个节点
            pre.next=quick;//前一个节点指向第二个节点
            pre=slow;//将前一个节点更新为第一个节点
            slow=slow.next;//更新下一轮的第一个节点
            if(slow!=null) quick=slow.next;//更新下一轮的第二个节点
            else quick=null;
        }
        return temp.next;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode first=head,second=head.next;

        first.next=solution2(second.next);
        second.next=first;

        return second;
    }

}
