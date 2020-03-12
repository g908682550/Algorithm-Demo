package code_test;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 */
public class GraphMinPath{
    static Graph graph;
    static boolean[] visited;
    public static void main(String[] args){
        graph=new Graph();
        visited=new boolean[graph.V+1];
        int maxlen=bfs(0);
        System.out.println(2*graph.E-(maxlen-1));
    }

    public static int bfs(int s){
        int res=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=true;
        while(!queue.isEmpty()){
            Queue<Integer> queue1=new LinkedList<>(queue);
            queue.clear();
            while(!queue1.isEmpty()){
                int v=queue1.poll();
                visited[v]=true;
                for(int w:graph.adj[v]){
                    if(!visited[w]){
                        queue.offer(w);
                        visited[w]=true;
                    }
                }
            }
            res++;
        }
        return res;
    }
}

class Graph{
    public int V;
    public int E;
    public HashSet<Integer>[] adj;

    public Graph(){
        Scanner scanner=new Scanner(System.in);
        V=scanner.nextInt();
        adj=new HashSet[V];
        for(int i=0;i<V;i++)
            adj[i]=new HashSet<>();
        E=V-1;
        for(int i=0;i<E;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            adj[a-1].add(b-1);
            adj[b-1].add(a-1);
        }
    }
}
