package leetcode;

public class AddTwoNumbers2 {


    /**
     * 分别遍历l1和l2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution1(ListNode l1, ListNode l2){
        ListNode head=new ListNode(0);
        ListNode temp=head;
        boolean flag=false;//进位的标志
        int m=0,n=0,num=0;
        while(l1!=null||l2!=null){
            m=(l1==null?0:l1.val);//取出l1的值，如果不存在为0
            n=(l2==null?0:l2.val);//取出l2的值，如果不存在为0
            if(flag) num=m+n+1;//如果有进位，多+1
            else num =m+n;
            flag=false;//默认没有
            if(num>9) flag=true;
            num=num%10;
            head.next=new ListNode(num);//创建一个结点保存
            head=head.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(flag) head.next=new ListNode(1);//最后如果还有进位，继续赋值
        return temp.next;
    }

}
