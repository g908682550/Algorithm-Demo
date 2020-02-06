package graph.dfs;

import graph.build.Graph;

/**
 * dfs二分图的判定
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
