package leetcode;

public class RemoveElements203 {


    /**
     * 快慢指针，快指针找非val值的值，如果不是，更新给慢指针
     * @param head
     * @param val
     * @return
     */
    public ListNode solution1(ListNode head, int val){
        ListNode result=new ListNode(0);
        ListNode temp=result;
        result.next=head;
        ListNode quick=head;
        while(quick!=null){
            if(quick.val==val) quick=quick.next;
            else{
                result.next=quick;
                result=result.next;
                quick=quick.next;
            }
        }
        result.next=null;
        return temp.next;
    }

    /**
     * 设立一个哑节点，单指针遍历
     * @param head
     * @param val
     * @return
     */
    public ListNode solution2(ListNode head,int val){
        ListNode result=new ListNode(0);
        ListNode temp=result;
        result.next=head;
        while(result!=null&&result.next!=null){
            if(result.next.val==val)
                result.next=result.next.next;
            else result=result.next;
        }
        return temp.next;
    }

}
