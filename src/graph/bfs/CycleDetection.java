package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs判断图中是否有环
 */
public class CycleDetection {

    private Graph G;
    private boolean[] visited;
    private boolean hasCycle;

    public CycleDetection(Graph G){
        this.G=G;
        visited=new boolean[G.getV()];

        for(int v=0;v<G.getV();v++){
            if(!visited[v])
                bfs(v);
        }
    }

    private void bfs(int s){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=true;
        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int w:G.adj(v))
                if(!visited[w]){
                    queue.offer(w);
                    visited[w]=true;
                }else{
                    hasCycle=true;
                    break;
                }
            if(hasCycle) break;
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }


    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        CycleDetection cycleDetection=new CycleDetection(g);
        System.out.println(cycleDetection.hasCycle);
    }

}
