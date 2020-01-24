package leetcode;

public class MiddleNode876 {


    public ListNode solution1(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode quick=head,slow=head;
        while(quick!=null&&quick.next!=null){
            quick=quick.next;
            quick=quick.next;
            slow=slow.next;
        }
        return slow;
    }


}
