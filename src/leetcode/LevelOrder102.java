package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 {


    /**
     * 借助于队列实现层次遍历
     * @param root
     * @return
     */
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution1(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return result;
        queue.offer(root);
        int level=0;
        while(queue.size()>0){
            result.add(new ArrayList<Integer>());
            int currLength=queue.size();
            for(int i=0;i<currLength;i++){
                TreeNode node=queue.poll();
                result.get(level).add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            level++;
        }
        return result;
    }

    /**
     * 递归进行层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> solution2(TreeNode root) {
        if(root==null) return result;
        helper(root,0);
        return result;
    }

    public void helper(TreeNode node,int level){
        if(level==result.size()) result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        if(node.left!=null) helper(node.left,level+1);
        if(node.right!=null) helper(node.right,level+1);
    }


}
