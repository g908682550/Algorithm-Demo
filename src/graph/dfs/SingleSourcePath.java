package graph.dfs;

import graph.build.Graph;

import java.util.ArrayList;


/**
 * 求单源路径
 */
public class SingleSourcePath {

    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;

    public SingleSourcePath(Graph G,int s){
        G.validateVertex(s);
        this.G=G;
        this.s=s;
        visited=new boolean[G.getV()];
        pre=new int[G.getV()];
        for(int i=0;i<pre.length;i++) pre[i]=-1;
        dfs(s,s);
    }

    private void dfs(int v,int parent){
        pre[v]=parent;
        visited[v]=true;
        for(int w:G.adj(v))
            if(!visited[w])
                dfs(w,v);
    }

    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t){
        ArrayList<Integer> res=new ArrayList<>();
        if(!isConnectedTo(t)) return res;
        int curr=t;
        while(curr!=s){
            res.add(0,curr);
            curr=pre[curr];
        }
        res.add(0,s);
        return res;
    }

    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        SingleSourcePath singleSourcePath=new SingleSourcePath(g,1);
        System.out.println(singleSourcePath.path(6));

    }
}
