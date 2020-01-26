package leetcode;

import java.util.*;

public class LevelOrderBottom107 {

    List<List<Integer>> result=new ArrayList<>();

    /**
     * 借助于队列进行由底至上的层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> solution1(TreeNode root){
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            result.add(0,new ArrayList<Integer>());
            int currLength=queue.size();
            for(int i=0;i<currLength;i++){
                TreeNode node=queue.poll();
                result.get(0).add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 递归调用，最后将其反转
     * @param root
     * @return
     */
    public List<List<Integer>> solution2(TreeNode root){
        if(root==null) return result;
        helper(root,0);
        Collections.reverse(result);
        return result;
    }

    public void helper(TreeNode node,int level){
        if(level==result.size()) result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        if(node.left!=null) helper(node.left,level+1);
        if(node.right!=null) helper(node.right,level+1);
    }

}
