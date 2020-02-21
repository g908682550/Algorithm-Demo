package offer;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

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

    public List<List<Integer>> solution(TreeNode root, int sum){
        helper(root,new ArrayList<>(),sum);
        return result;
    }

    public void helper(TreeNode node,List<Integer> list,int target){
        if(node==null) return;
        if(target==0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(node.val>target) return;
        else{
            list.add(node.val);
            helper(node.left,list,target-node.val);
            helper(node.right,list,target-node.val);
            list.remove(list.size()-1);
        }
    }

}
