package code_test;

import leetcode.TreeNode;
import offer.Codec37;

import java.util.HashSet;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        Codec37 codec37 = new Codec37();
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(2);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(3);
        TreeNode node6=new TreeNode(1);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        node3.left=node5;
        node3.right=node6;
//        System.out.println();
        String s = codec37.serialize(root);
        System.out.println(s);
        codec37.deserialize(s);
        System.out.println();
    }
}
