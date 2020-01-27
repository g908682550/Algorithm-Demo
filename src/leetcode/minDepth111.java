package leetcode;

public class minDepth111 {


    /**
     * 返回二叉树的最小深度（根节点到叶子节点的最短距离），递归
     * @param root
     * @return
     */
    public int solution1(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(root.left!=null){
            left=solution1(root.left);
        }
        if(root.right!=null){
            right=solution1(root.right);
        }
        return Math.min(left,right)+1;
    }

    /**
     * 仍是递归
     * @param root
     * @return
     */
    public int solution2(TreeNode root){
        if(root==null) return 0;
        if(root.left==null||root.right==null) return Math.max(solution2(root.left),solution2(root.right))+1;
        return Math.min(solution2(root.left),solution2(root.right))+1;
    }

}
