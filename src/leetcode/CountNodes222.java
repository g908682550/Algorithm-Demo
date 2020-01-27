package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountNodes222 {


    /**
     * 借助于完全二叉树性质递归求解
     * @param root
     * @return
     */
    public int solution1(TreeNode root){
        if(root==null) return 0;
        int left_height=0,right_height=0;
        TreeNode left=root,right=root;
        while(left!=null){
            left=left.left;
            left_height++;
        }
        while(right!=null){
            right=right.right;
            right_height++;
        }
        if(left_height==right_height) return (int)Math.pow(2,left_height)-1;
        return 1+solution1(root.left)+solution1(root.right);
    }

    /**
     * 普通求解
     */
    List<TreeNode> list=new ArrayList<>();

    public int solution2(TreeNode root){
        preOrder(root);
        return list.size();
    }

    public void preOrder(TreeNode node){
        if(node==null) return;
        list.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }

}
