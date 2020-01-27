package leetcode;

public class SumOfLeftLeaves404 {

    Integer result=0;

    /**
     * 递归求解二叉树左叶子节点之和
     * @param root
     * @return
     */
    public int solution(TreeNode root){
        if(root==null) return result;
        if(root.left!=null) {
            TreeNode node=root.left;
            if(node.left==null&&node.right==null) result+=node.val;
            solution(root.left);
        }if(root.right!=null){
            solution(root.right);
        }
        return result;
    }


}
