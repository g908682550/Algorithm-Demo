package leetcode;

public class InvertTree226 {


    public TreeNode solution(TreeNode root){
        if(root==null) return null;
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        if(root.left!=null) solution(root.left);
        if(root.right!=null) solution(root.right);
        return root;
    }

}
