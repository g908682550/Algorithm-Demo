package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal144 {

    public void test(){

    }

    /**
     * 递归方式前序遍历
     */
    List<Integer> result=new ArrayList<>();

    public List<Integer> solution(TreeNode root){
        preOrder(root);
        return result;
    }
    public void preOrder(TreeNode node){
        if(node==null) return;
        result.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 借助于栈进行迭代法遍历
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node!=null){
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}
