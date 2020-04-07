package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class CloneGraph133 {

    private class Node{
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    @Test
    public void test(){
        Node one=new Node(1,new ArrayList<>());
        Node two=new Node(2,new ArrayList<>());
        Node three=new Node(3,new ArrayList<>());
        Node four=new Node(4,new ArrayList<>());
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(one);
        four.neighbors.add(three);
        solution(one);
    }

    Map<Integer,Node> map=new HashMap<>();
    boolean[] flag=new boolean[101];

    public Node solution(Node node){
        map.put(node.val,new Node(node.val,new ArrayList<Node>()));
        dfs(node);
        return map.get(1);
    }

    public void dfs(Node node){
        flag[node.val]=true;
        Node inner=map.get(node.val);
        for(Node curr:node.neighbors){
            if(!map.containsKey(curr.val)) map.put(curr.val,new Node(curr.val,new ArrayList<>()));
            inner.neighbors.add(map.get(curr.val));
        }
        for(Node curr:node.neighbors){
            if(!flag[curr.val]) dfs(curr);
        }
    }

}
