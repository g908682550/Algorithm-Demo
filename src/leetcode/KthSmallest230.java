package leetcode;

import java.util.Stack;

public class KthSmallest230 {


    /**
     * 中序遍历，第k个元素时返回
     * @param root
     * @param k
     * @return
     */
    public int solution(TreeNode root,int k){
        Stack<TreeNode> stack=new Stack<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k==0) return root.val;
            root=root.right;
        }
    }

}
