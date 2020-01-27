package leetcode;

public class HasPathSum112 {

    public boolean solution(TreeNode root,int sum){
        if(root==null) return false;//考虑根节点的情况
        if(root.left==null&&root.right==null) return root.val==sum;
        return solution(root.left,sum-root.val)||solution(root.right,sum-root.val);
    }

}
