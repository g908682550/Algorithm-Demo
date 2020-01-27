package leetcode;

public class maxDepth104 {

    /**
     * 递归返回最大深度
     * @param root
     * @return
     */
    public int solution(TreeNode root){
        if(root==null) return 0;
        return Math.max(solution(root.left),solution(root.right))+1;
    }

}
