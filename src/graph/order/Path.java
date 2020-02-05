package graph.order;

import graph.build.Graph;

import java.util.ArrayList;

/**
 * 求两点路径
 */
public class Path {

    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;
    private int t;

    public Path(Graph G,int s,int t){
        G.validateVertex(s);
        G.validateVertex(t);
        this.G=G;
        this.s=s;
        this.t=t;
        visited=new boolean[G.getV()];
        pre=new int[G.getV()];
        for(int i=0;i<pre.length;i++) pre[i]=-1;
        dfs(s,s);
    }

    private boolean dfs(int v,int parent){
        pre[v]=parent;
        visited[v]=true;
        if(v==t) return true;
        for(int w:G.adj(v))
            if(!visited[w]&&dfs(w,v))  return true;
        return false;
    }

    public boolean isConnectedTo(){
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(){
        ArrayList<Integer> res=new ArrayList<>();
        if(!isConnectedTo()) return res;
        int curr=t;
        while(curr!=s){
            res.add(0,curr);
            curr=pre[curr];
        }
        res.add(0,s);
        return res;
    }

    public static void main(String[] args) {
        Graph graph=new Graph("g.txt");
        Path path=new Path(graph,0,5);
        System.out.println(path.path());
    }
}
