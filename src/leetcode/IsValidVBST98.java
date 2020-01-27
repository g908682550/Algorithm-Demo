package leetcode;

import java.util.Stack;

public class IsValidVBST98 {


    /**
     * 递归验证是否为二叉搜索树
     * @param node
     * @return
     */
    public boolean solution1(TreeNode node){
        return helper(node,null,null);
    }

    public boolean helper(TreeNode node,Integer min,Integer max){
        if(node==null) return true;
        Integer curr=node.val;
        if(min!=null&&curr<=min) return false;//如果没有下界限制，则不用判断
        if(max!=null&&curr>=max) return false;//如果没有上界限制，则不用判断
        if(!helper(node.left,min,curr)) return false;//对当前节点的左节点，其上界为当前节点的值，下界为上次传入的下界
        if(!helper(node.right,curr,max)) return false;//对当前节点的右节点，其上界为上次传入的上界，下界为当前节点的值
        return true;//之前都判断成功，则为平衡二叉树
    }

    /**
     * 中序遍历验证
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root){
        if(root==null) return true;
        double flag=-Double.MAX_VALUE;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.val<=flag) return false;
            flag=root.val;
            root=root.right;
        }
        return true;
    }

}
