package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class pathSum113 {

    @Test
    public void test(){
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(8);
        TreeNode node3=new TreeNode(11);
        TreeNode node4=new TreeNode(13);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(7);
        TreeNode node7=new TreeNode(2);
        TreeNode node8=new TreeNode(5);
        TreeNode node9=new TreeNode(1);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=null;
        node3.left=node6;
        node3.right=node7;
        node2.left=node4;
        node2.right=node5;
        node5.left=node8;
        node5.right=node9;
        solution(root,22);

    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution(TreeNode root,int sum){
        helper(root,sum,new ArrayList<>());
        return result;
    }

    public void helper(TreeNode node,int num,List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        if(node.left==null&&node.right==null&&node.val==num) result.add(new ArrayList<>(list));//加入数组中时需要创建一个新的数组
        helper(node.left,num-node.val,list);
        helper(node.right,num-node.val,list);
        list.remove(list.size()-1);
    }


}
