package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs二分图的判定
 */
public class BipartitionDetection {

    private Graph G;
    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite=true;

    public BipartitionDetection(Graph G){
        this.G=G;
        visited=new boolean[G.getV()];
        colors=new int[G.getV()];
        for(int v=0;v<G.getV();v++) colors[v]=-1;

        for(int v=0;v<G.getV();v++){
            if(!visited[v])
                bfs(v);
        }
    }

    private void bfs(int s){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=true;
        colors[s]=1;
        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int w:G.adj(v))
                if(!visited[w]) {
                queue.offer(w);
                visited[w]=true;
                colors[w]=1-colors[v];
            }else{
                if(colors[w]==colors[v]) {
                    isBipartite=false;
                    break;
                }
            }
            if(!isBipartite) break;
        }
    }


    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        GraphBFS graphBFS=new GraphBFS(g);
        System.out.println(graphBFS.order());
    }

}
