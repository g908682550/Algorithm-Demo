package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleII142 {

    public ListNode solution1(ListNode head){
        if(head==null||head.next==null) return null;
        ListNode quick=head,slow=head;
        while(quick!=null&&quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
            if(quick==slow){
                slow=head;
                while(slow!=quick){
                    slow=slow.next;
                    quick=quick.next;
                }
                if(quick==slow) return quick;
            }
        }
        return null;
    }

    public ListNode solution2(ListNode head){
        Set<ListNode> set=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp)) return temp;
            set.add(temp);
            temp=temp.next;
        }
        return null;
    }

}
