package graph.order;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的深度优先遍历，时间复杂度O(V+E)
 */
public class GraphDFS {

    private Graph G;
    private boolean[] visited;
    private List<Integer> pre=new ArrayList<>();
    private List<Integer> post=new ArrayList<>();

    public GraphDFS(Graph G){
        this.G=G;
        visited=new boolean[G.getV()];
        for(int v=0;v<G.getV();v++)
            if(!visited[v])
                dfs(0);
    }

    private void dfs(int v){
        visited[v]=true;
        pre.add(v);
        for(int w:G.adj(v))
            if(!visited[w])
                dfs(w);
        post.add(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.pre);
    }
}
