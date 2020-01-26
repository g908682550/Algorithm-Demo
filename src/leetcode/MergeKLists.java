package leetcode;

import java.util.PriorityQueue;

public class MergeKLists {


    /**
     * 借助于优先队列进行合并
     * @param lists
     * @return
     */
    public ListNode solution(ListNode[] lists){
        ListNode result=new ListNode(0),temp=result;
        if(lists.length==0) return null;//数组为空返回null
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(lists.length,(a, b)->a.val-b.val);
        for(ListNode node:lists) if(node!=null) minHeap.add(node);//子数组为空不加入堆中

        while(minHeap.size()>0){
            ListNode curr=minHeap.poll();
            result.next=curr;
            result=result.next;
            curr=curr.next;
            if(curr!=null) minHeap.add(curr);
        }
        return temp.next;
    }

}
