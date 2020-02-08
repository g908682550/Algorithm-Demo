package offer;

import leetcode.TreeNode;

import java.util.Stack;

public class KthNode {

    /**
     * 中序遍历
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode pRoot,int k){
        int count=1;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||pRoot!=null){
            while(pRoot!=null){
                stack.push(pRoot);
                pRoot=pRoot.left;
            }
            pRoot=stack.pop();
            if(count==k) return pRoot;
            count++;
            pRoot=pRoot.right;
        }
        return null;
    }

}
