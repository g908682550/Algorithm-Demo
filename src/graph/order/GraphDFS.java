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
    private int[] colors;
    private boolean isBipartite=true;

    public GraphDFS(Graph G){
        this.G=G;
        visited=new boolean[G.getV()];
        colors=new int[G.getV()];
        for(int v=0;v<G.getV();v++) colors[v]=-1;
        for(int v=0;v<G.getV();v++)
            if(!visited[v]&&!dfs(v,0))
            {
                isBipartite=false;
                break;
            }

    }

    private boolean dfs(int v,int color){
        visited[v]=true;
        colors[v]=color;
        for(int w:G.adj(v))
            if(!visited[w]) if(!dfs(w,1-color)) return false;
            else if(colors[w]==colors[v]) return false;
            return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
    }
}
