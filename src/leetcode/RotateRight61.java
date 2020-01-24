package leetcode;

public class RotateRight61 {




    public void test(){

    }

    public ListNode solution(ListNode head, int k){
        if(head==null||head.next==null) return head;
        ListNode temp=head;
        int length=1;
        //首先计算出链表长度并将链表闭成环状
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        temp.next=head;
        //返记录新链表的起始位置
        int n=length-(k%length);
        ListNode result=head;
        for(int i=0;i<n;i++){
            result=result.next;
        }
        //将新链表尾结点置为null
        temp=result;
        while(temp.next!=result) temp=temp.next;
        temp.next=null;
        return result;
    }

}
