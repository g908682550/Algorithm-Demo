package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes0201 {

    public ListNode solution(ListNode head){
        ListNode result=new ListNode(0),temp=result;
        Set<Integer> set=new HashSet<>();
        while(head!=null){
            if(!set.contains(head.val)){
                result.next=head;
                result=result.next;
                set.add(head.val);
            }
            head=head.next;
        }
        result.next=null;
        return temp.next;
    }

}
