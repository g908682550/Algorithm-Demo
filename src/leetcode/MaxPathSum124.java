package leetcode;

public class MaxPathSum124 {

    int result=Integer.MIN_VALUE;

    public int solution(TreeNode root){
        getMax(root);
        return result;
    }

    /**
     * 当前节点作为父节点时需算上自己的值和左右节点值判断
     * 当前节点仅作为父节点的子节点时只能带上一个自己的孩子节点
     * @param node
     * @return
     */
    public int getMax(TreeNode node){
        if(node==null) return 0;
        int left=Math.max(0,getMax(node.left));
        int right=Math.max(0,getMax(node.right));
        result=Math.max(result,left+right+node.val);
        return Math.max(left,right)+node.val;
    }

}
