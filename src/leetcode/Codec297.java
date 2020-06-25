package leetcode;

import org.junit.Test;

import java.util.*;

public class Codec297 {

    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        String serialize=serialize(root);
        System.out.println(serialize);
        TreeNode node=deserialize(serialize);
        System.out.println(node);

    }

    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder result=new StringBuilder();
        result.append("["+root.val+",");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null) {
                result.append(curr.left.val+",");
                queue.add(curr.left);
            }else{
                result.append("null,");
            }
            if(curr.right!=null){
                result.append(curr.right.val+",");
                queue.add(curr.right);
            }else{
                result.append("null,");
            }
        }
        while(result.length()>5&&result.substring(result.length()-5,result.length()).equals("null,")){
            result=new StringBuilder(result.substring(0,result.length()-5));
        }
        result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String data1=data.substring(1,data.length()-1);
        String[] datas=data1.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(datas[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for(int i=1;i<datas.length;i+=2){
            String curr1=datas[i];
            String curr2=i+1<datas.length?datas[i+1]:"null";
            TreeNode node1=null,node2=null;
            if(!curr1.equals("null")) node1=new TreeNode(Integer.parseInt(curr1));
            if(!curr2.equals("null")) node2=new TreeNode(Integer.parseInt(curr2));
            TreeNode pre=queue.poll();
            pre.left=node1;
            pre.right=node2;
            if(node1!=null) queue.add(node1);
            if(node2!=null) queue.add(node2);
        }
        return root;
    }

}
