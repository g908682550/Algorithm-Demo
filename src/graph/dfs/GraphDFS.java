package graph.dfs;

import graph.build.Graph;

import java.util.ArrayList;

/**
 * 图的深度优先遍历，时间复杂度O(V+E)
 */
public class GraphDFS {

    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> pre=new ArrayList<>();
    private ArrayList<Integer> post=new ArrayList<>();

    public GraphDFS(Graph G){
        this.G=G;
        visited=new boolean[G.getV()];
        for(int v=0;v<G.getV();v++)
            if(!visited[v]) dfs(v);

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
    }
}
