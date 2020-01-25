package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal94 {

    List<Integer> result=new ArrayList<>();

    /**
     * 递归调用遍历
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root){
        inorder(root);
        return result;
    }

    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        result.add(node.val);
        inorder(node.right);
    }

    /**
     * 基于栈的迭代遍历方法
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){//当前节点不为空或栈不为空
            while(root!=null){//节点不为空，找到当前节点的最左节点
                stack.push(root);
                root=root.left;
            }
            //到这里时root已经为null
            root=stack.pop();//从栈顶取出一个节点
            result.add(root.val);
            root=root.right;//如果右节点不为空，放入栈中
        }
        return result;
    }

}
