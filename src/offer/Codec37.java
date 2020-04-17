package offer;

import leetcode.TreeNode;
import java.util.*;
public class Codec37 {

    public String serialize(TreeNode root) {
        if(root==null) {
            return "[]";
        }
        List<String> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        list.add(root.val+"");
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            TreeNode left=curr.left,right=curr.right;
            if(left!=null){
                list.add(curr.left.val+"");
                queue.add(left);
            }else {
                list.add("null");
            }
            if(right!=null){
                list.add(curr.right.val+"");
                queue.add(right);
            }else {
                list.add("null");
            }
        }
        Collections.reverse(list);
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next()!="null") break;
            iterator.remove();
        }
        Collections.reverse(list);
        StringBuilder res=new StringBuilder();
        res.append("["+list.get(0)+",");
        for(int i=1;i<list.size()-1;i++) {
            res.append(list.get(i)+",");
        }
        res.append(list.get(list.size()-1)+"]") ;
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("[]")) {
            return null;
        }
        String s= data.substring(1, data.length() - 1);
        String[] split = s.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for(int i=1;i<split.length;i+=2){
            String curr1=split[i];
            String curr2=split[i+1];
            TreeNode node1=null,node2=null;
            if(!curr1.equals("null")) {
                node1=new TreeNode(Integer.parseInt(curr1));
            }
            if(!curr2.equals("null")){
                node2=new TreeNode(Integer.parseInt(curr2));
            }
            TreeNode pre=queue.poll();
            pre.left=node1;
            pre.right=node2;
            if(node1!=null) {
                queue.add(node1);
            }
            if(node2!=null){
                queue.add(node2);
            }
        }
        return root;
    }

}
