package leetcode;

public class DeleteNode237 {


    /**
     * 保存下个节点的值为当前节点
     * @param node
     */
    public void solution1(ListNode node){
        ListNode next=node.next;
        if(next==null) node=null;
        else{
            node.val=next.val;
            node.next=next.next;
        }
    }

}
