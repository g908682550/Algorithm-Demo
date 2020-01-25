package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal145 {

    List<Integer> result=new ArrayList<>();

    /**
     * 递归遍历
     * @param root
     * @return
     */
    public List<Integer> solution(TreeNode root){
        postOrder(root);
        return result;
    }

    public void postOrder(TreeNode node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        result.add(node.val);
    }

    /**
     * 借助于栈实现迭代遍历
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            if(root!=null){
                result.add(0,root.val);
                stack.push(root.left);
                stack.push(root.right);

            }
        }
        return result;
    }

}
