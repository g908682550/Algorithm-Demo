package leetcode;

import org.junit.Test;

public class SortList148 {

    @Test
    public void test(){

        ListNode head=new ListNode(4);
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(7);
        ListNode node5=new ListNode(0);
        ListNode node6=new ListNode(6);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        ListNode result=solution(head);
        ListNode.printLink(result);
    }

    /**
     * 自底向上的归并排序
     * @param head
     * @return
     */
    public ListNode solution(ListNode head){
        if(head==null||head.next==null) return head;//链表问题传统开头
        ListNode result=new ListNode(0);//设立一个哑节点，哑节点的下一个节点指向排序后的第一个
        result.next=head;
        ListNode pre=result;//pre用作遍历
        //如果subSort（pre,i)返回的为null，说明总长度小于i，可以结束排序
        for(int i=1;(pre=subSort(pre,i))!=null;i=i+i){
            while(pre!=null){
                pre=subSort(pre,i);
            }
            pre=result;
        }
        return result.next;
    }
    public ListNode subSort(ListNode pre,Integer num){
        int slowNum=num,quickNum=num;
        ListNode slow=pre.next,quick=pre.next;
        for(int i=0;i<num;i++){
            if(quick==null) return null;//说明总长度小于一个num值，局部已经有序
            quick=quick.next;
        }
        while(slowNum>0&&quickNum>0&&quick!=null){//遍历快指针和慢指针，将其连接到pre上
            if(slow.val<quick.val){
                pre.next=slow;
                slow=slow.next;
                slowNum--;
            }else{
                pre.next=quick;
                quick=quick.next;
                quickNum--;
            }
            pre=pre.next;//将pre向后移动一位
        }
        if(slowNum>0){//说明快指针已经遍历完达到下一次子数组的第一个或者快指针为null时，还有慢指针没有遍历完成
            pre.next=slow;
            while(slowNum>0){//对慢指针继续遍历
                pre=pre.next;
                slowNum--;
            }
            pre.next=quick;//将子数组的下一个节点与当前pre进行连接
        }
        if(quickNum>0&&quick!=null){//说明慢指针遍历完成，快指针还有剩余且不为null
            pre.next=quick;
            while(quickNum>0&&pre!=null){
                pre=pre.next;
                quickNum--;
            }
        }
        return pre;//返回排序后子数组的最后一个元素
    }

}
