package leetcode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val=x;}

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void printLink(ListNode node){
        StringBuilder s=new StringBuilder();
        while(node!=null){
            s.append(""+node.val);
            s.append("->");
            node=node.next;
        }
        s.append("null");
        System.out.println(s.toString());
    }
}
