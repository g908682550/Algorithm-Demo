package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {


    List<String> result=new ArrayList<>();

    public List<String> solution(TreeNode root){
        if(root==null) return result;
        String s=root.val+"";
        if(root.left==null&&root.right==null) result.add(s);
        helper(root.left,s);
        helper(root.right,s);
        return result;
    }

    public void helper(TreeNode node,String s){
        if(node==null) return;
        s=s+"->"+node.val;
        if(node.left==null&&node.right==null) result.add(s);
        helper(node.left,s);
        helper(node.right,s);
    }

}
