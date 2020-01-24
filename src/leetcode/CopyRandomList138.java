package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {

    Map<Node,Node> map=new HashMap<>();

    /**
     * 借助于map，递归调用
     * @param head
     * @return
     */
    public Node solution1(Node head){
        if(head==null) return head;
        if(map.containsKey(head)) return map.get(head);//如果map已经包含当前节点，直接返回对应的新节点
        Node node=new Node(head.val);
        map.put(head,node);
        node.next=solution1(head.next);//复制head.next
        node.random=solution1(head.random);//复制head.random
        return node;
    }

    /**
     * 借助于map，迭代遍历
     * @param head
     * @return
     */
    public Node solution2(Node head){
        Map<Node,Node> map=new HashMap<>();
        if(head==null) return head;
        Node node=new Node(head.val),temp=node;
        map.put(head,node);//head遍历
        while(head!=null){
            if(head.next!=null&&!map.containsKey(head.next)) map.put(head.next,new Node(head.next.val));//如果map中不存在下一个节点对应的节点，将其放入map
            if(head.random!=null&&!map.containsKey(head.random)) map.put(head.random,new Node(head.random.val));//如果map中不存在随机节点对应的节点，将其放入map
            node.next=map.get(head.next);
            node.random=map.get(head.random);
            head=head.next;
            node=node.next;
        }
        return temp;
    }

    /**
     * 在新结点的相邻位置复制一个节点，然后再进行矫正，最后返回
     * @param head
     * @return
     */
    public Node solution3(Node head){
        if(head==null) return null;
        Node temp=head;
        while(temp!=null){
            Node node=new Node(temp.val);
            node.next=temp.next;
            temp.next=node;
            temp=node.next;
        }
        temp=head;
        while(temp!=null){
            temp.next.random=temp.random==null?null:temp.random.next;
            temp=temp.next.next;
        }
        Node result=head.next,newList=result,oldList=head;
        while(oldList!=null){
            oldList.next=oldList.next.next;
            newList.next=newList.next==null?null:newList.next.next;
            oldList=oldList.next;
            newList=newList.next;
        }
        return result;
    }

}
