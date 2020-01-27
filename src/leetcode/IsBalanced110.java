package leetcode;

public class IsBalanced110 {



    public boolean solution(TreeNode root){
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right))>1) return false;//如果当前左子树与右子树高度差大于1，返回false
        if(solution(root.left)&&solution(root.right)) return true;//左子树和右子树都为平衡，返回true
        else return false;
    }

    /**
     * 计算二叉树的最大深度
     * @param node
     * @return
     */
    public int height(TreeNode node){
        if(node==null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }

}
