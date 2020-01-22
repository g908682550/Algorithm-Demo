package leetcode;

public class MergeTwoLists21 {



    public ListNode solution1(ListNode l1, ListNode l2){
        ListNode result=new ListNode(0),temp=result;
        while(l1!=null||l2!=null){
            if(l1==null) {
                result.next=l2;
                break;
            }
            if(l2==null){
                result.next=l1;
                break;
            }
            if(l1.val<l2.val){
                result.next=l1;
                result=result.next;
                l1=l1.next;
            }else{
                result.next=l2;
                result=result.next;
                l2=l2.next;
            }
        }
        return temp.next;
    }

}
