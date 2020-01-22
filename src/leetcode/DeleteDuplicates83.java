package leetcode;

import org.junit.Test;

public class DeleteDuplicates83 {


    @Test
    public void test(){

    }

    /**
     * 借助于快慢指针
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head){
        if(head==null) return null;
        ListNode slow=head,quick=head;
        while(quick!=null){
            if(quick.val==slow.val) quick=quick.next;
            else {
                slow.next=quick;
                slow=slow.next;
            }
        }
        slow.next=null;//最后需将慢指针的后置置为null
        return head;
    }

}
