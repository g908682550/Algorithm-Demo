package leetcode;

public class LowestCommonAncestor235 {


    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(q.val<root.val&&p.val<root.val) return solution(root.left,p,q);
        if(q.val>root.val&&p.val>root.val) return solution(root.right,p,q);
        return root;
    }

}
