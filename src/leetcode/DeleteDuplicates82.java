package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeleteDuplicates82 {


    /**
     * 借助于3个指针进行遍历操作
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head){
        if(head==null||head.next==null) return head;
        boolean flag=false;//如果出现了重复元素为true，否则为false
        ListNode result=new ListNode(0),temp=result,curr=head,next=null;
        while(curr!=null){
            next=curr.next;
            while(next!=null&&curr.val==next.val){//如果当前元素和下一个元素相等，找到第一个不相等的
                flag=true;
                next=next.next;
            }
            if(flag){//如果出现了重复元素
                flag=false;
                curr=next;
                continue;//重新循环判断
            }
            result.next=curr;//此时的curr一定为非重复元素
            result=result.next;
            curr=next;
        }
        result.next=null;//最后需将结果的最后置为null
        return temp.next;
    }



    /**
     * 借助于Map进行存储
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head){
        if(head==null||head.next==null) return head;
        Map<Integer,Integer> map=new LinkedHashMap<>();
        while(head!=null){
            map.put(head.val,map.getOrDefault(head.val,0)+1);
            head=head.next;
        }
        ListNode result=new ListNode(0),temp=result;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                result.next=new ListNode(entry.getKey());
                result=result.next;
            }
        }
        return temp.next;
    }

}
