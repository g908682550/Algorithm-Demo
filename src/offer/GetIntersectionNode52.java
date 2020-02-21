package offer;

import leetcode.ListNode;

public class GetIntersectionNode52 {

    public ListNode solution(ListNode headA, ListNode headB){
        if(headA==null||headB==null) return null;
        ListNode p1=headA,p2=headB;
        while(p1!=p2){
            p1=p1==null?headA:p1.next;
            p2=p2==null?headB:p2.next;
        }
        return p1;
    }

}
