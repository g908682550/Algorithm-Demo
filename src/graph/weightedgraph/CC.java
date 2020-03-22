package graph.weightedgraph;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 求联通分量
 */
public class CC {

    private WeightedGraph G;
    private int[] visited;
    private int cccount;

    public CC(WeightedGraph G){
        this.G=G;
        visited=new int[G.getV()];
        for(int i=0;i<visited.length;i++) visited[i]=-1;
        for(int v=0;v<G.getV();v++)
            if(visited[v]==-1){
                dfs(v,cccount);
                cccount++;
            }
    }

    public List<Integer>[] components(){
        ArrayList<Integer>[] res=new ArrayList[cccount];

        for(int i=0;i<cccount;i++) res[i]=new ArrayList<>();

        for(int v=0;v<G.getV();v++)
            res[visited[v]].add(v);

        return res;
    }

    private void dfs(int v,int cccount){
        visited[v]=cccount;
        for(int w:G.adj(v))
            if(visited[w]==-1)
                dfs(w,cccount);
    }

    public int count(){
//        for(int e:visited) System.out.print(e+"");
//        System.out.println();
        return cccount;
    }

    public boolean isConnected(int v,int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v]==visited[w];
    }

}
