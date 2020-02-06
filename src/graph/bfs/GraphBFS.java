package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 */
public class GraphBFS {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> order=new ArrayList<>();

    public GraphBFS(Graph G){
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
            order.add(v);
            for(int w:G.adj(v)) if(!visited[w]) {
                queue.offer(w);
                visited[w]=true;
            }
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        GraphBFS graphBFS=new GraphBFS(g);
        System.out.println(graphBFS.order());
    }

}
