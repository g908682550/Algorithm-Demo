package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences0409 {

    @Test
    public void test(){
        TreeNode root=new TreeNode(2);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(3);
//        TreeNode node3=new TreeNode(4);
//        TreeNode node4=new TreeNode(5);
        root.left=node1;
        root.right=node2;
//        node1.left=node3;
//        node1.right=node4;
        System.out.println(solution(root));
    }

    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    /**
     * 回溯
     * @param root
     * @return
     */
    public List<List<Integer>> solution(TreeNode root){
        if(root==null){
            result.add(new ArrayList<>());
            return result;
        }
        List<TreeNode> list=new ArrayList<>();
        list.add(root);
        helper(list);
        return result;
    }

    public void helper(List<TreeNode> list){
        if(list.size()==0){
            result.add(new ArrayList<>(path));
        }
        //next为后面需要进行的排列组合的列表
        List<TreeNode> next=new ArrayList<>(list);
        for(TreeNode node:list){
            path.add(node.val);
            next.remove(node);
            if(node.left!=null) next.add(node.left);
            if(node.right!=null) next.add(node.right);
            helper(next);
            if(node.left!=null) next.remove(node.left);
            if(node.right!=null) next.remove(node.right);
            next.add(node);
            path.remove(path.size()-1);
        }
    }


}
