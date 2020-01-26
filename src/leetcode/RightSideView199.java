package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {


    List<Integer> result=new ArrayList<>();

    /**
     * 借助于队列进行广度优先遍历，将最右侧元素加入结果集中
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root){
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(queue.size()>0){
            int currlength=queue.size();
            for(int i=0;i<currlength;i++){
                TreeNode node=queue.poll();
                if(level==result.size()) result.add(node.val);
                if(node.right!=null) queue.offer(node.right);
                if(node.left!=null) queue.offer(node.left);
            }
            level++;
        }
        return result;
    }

    /**
     * 递归进行广度优先遍历，将最右侧元素加入结果集中
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root){
        helper(root,0);
        return result;
    }

    public void helper(TreeNode node,int height){
        if(node==null) return;
        if(height==result.size()) result.add(node.val);
        helper(node.right,height+1);
        helper(node.left,height+1);
    }
}
