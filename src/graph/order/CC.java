package graph.order;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 求联通分量
 */
public class CC {

    private Graph G;
    private int[] visited;
    private int cccount;

    public CC(Graph G){
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

    public static void main(String[] args) {
        CC cc=new CC(new Graph("g.txt"));

        List<Integer>[] components = cc.components();
        for(int ccid=0;ccid<components.length;ccid++){
            System.out.print(ccid+": ");
            for(int w:components[ccid]) System.out.print(w+" ");
            System.out.println();
        }
    }
}
