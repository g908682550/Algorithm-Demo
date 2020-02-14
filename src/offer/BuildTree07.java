package offer;

import leetcode.TreeNode;

public class BuildTree07 {


    public TreeNode solution(int[] preorder, int[] inorder){
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    /**
     * 递归构建左右子节点
     * @param preorder
     * @param inorder
     * @param pi
     * @param pj
     * @param ii
     * @param ij
     * @return
     */
    public TreeNode helper(int[] preorder,int[] inorder,int pi,int pj,int ii,int ij) {
        if (pi > pj) return null;
        TreeNode node = new TreeNode(preorder[pi]);
        for (int i = ii; i <= ij; i++) {
            if (inorder[i] == preorder[pi]) {
                int len = i - ii;
                node.left = helper(preorder, inorder, pi + 1, pi + len, ii, i - 1);
                node.right = helper(preorder, inorder, pi + len + 1, pj, i + 1, ij);
            }
        }
        return node;
    }
}
