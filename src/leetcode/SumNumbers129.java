package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers129 {

    List<String> list=new ArrayList<>();

    public int solution(TreeNode root){
        if(root==null) return 0;
        helper(root,new StringBuilder());
        int result=0;
        for(String s:list){
            result+=Integer.parseInt(s);
        }
        return result;
    }

    public void helper(TreeNode node,StringBuilder s){
        if(node==null) return;
        s.append(node.val);
        if(node.left==null&&node.right==null) list.add(s.toString());
        helper(node.left,s);
        helper(node.right,s);
        s.deleteCharAt(s.length()-1);
    }
}
