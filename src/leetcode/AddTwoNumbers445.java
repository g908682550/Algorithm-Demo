package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers445 {



    public ListNode solution1(ListNode l1, ListNode l2){
        ListNode result=null;
        //分别将两个链表的值放入list中
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        ListNode tl1=l1,tl2=l2;
        while(tl1!=null){
            list1.add(0,tl1.val);
            tl1=tl1.next;
        }
        while(tl2!=null){
            list2.add(0,tl2.val);
            tl2=tl2.next;
        }
        int n=list1.size(),m=list2.size();
        //对list进行补全
        if(m>n)
            for(int i=0;i<m-n;i++) list1.add(0);
        else
            for(int i=0;i<n-m;i++) list2.add(0);
        //遍历两个list相加
        int max=Math.max(m,n);
        int val1=0,val2=0,num=0;
        ListNode node=null;
        boolean flag=false;
        for(int i=0;i<max;i++){
            val1=list1.get(i);
            val2=list2.get(i);
            if(flag) num=val1+val2+1;
            else num=val1+val2;
            if(num>9) flag=true;
            else flag=false;
            num=num%10;
            node=new ListNode(num);
            node.next=result;
            result=node;
        }
        ListNode other=null;
        if(flag) {
            other=new ListNode(1);
            other.next=node;
        }
        return flag==true? other:node;
    }
}
