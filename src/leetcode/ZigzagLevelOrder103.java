package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder103 {

    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node2.right=node4;
        solution(root);
    }

    List<List<Integer>> result=new ArrayList<>();

    /**
     * 借助于双端队列进行遍历
     * @param root
     * @return
     */
    public List<List<Integer>> solution(TreeNode root){
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<TreeNode>();
        deque.offer(root);
        int level=0;
        while(deque.size()>0){
            result.add(new ArrayList<Integer>());
            int currLength=deque.size();
            for(int i=0;i<currLength;i++){
                if(level%2==0){
                    //对于第1、3、5层等节点，从队首取出节点，并将左节点、右节点依次加入队列（队尾）
                    TreeNode node=deque.poll();
                    result.get(level).add(node.val);
                    if(node.left!=null) deque.offer(node.left);
                    if(node.right!=null) deque.offer(node.right);
                }else{
                    //对于2、4、6层等节点，从队尾取出节点，并将右节点、左节点依次加入队列（队首）
                    TreeNode node=deque.pollLast();
                    result.get(level).add(node.val);
                    if(node.right!=null) deque.offerFirst(node.right);
                    if(node.left!=null) deque.offerFirst(node.left);
                }
            }
            level++;
        }
        return result;
    }
}
