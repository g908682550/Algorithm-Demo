package graph.dfs;

import graph.build.Graph;

/**
 * dfs判断图中是否有环
 */
public class CycleDetection {
    private Graph G;
    private boolean[] visited;
    private boolean hasCycle;

    public CycleDetection(Graph G){
        this.G=G;
        visited=new boolean[G.getV()];
        for(int v=0;v<G.getV();v++)
            if(!visited[v]&&dfs(v,v)) {
                hasCycle=true;
                break;
            }

    }

    private boolean dfs(int v,int parent){
        visited[v]=true;
        for(int w:G.adj(v))
            if(!visited[w]&&dfs(w,v)) return true;
            else if(w!=parent) return true;
            return false;

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
