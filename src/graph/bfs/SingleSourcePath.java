package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历求单源路径
 */
public class SingleSourcePath {

    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;

    private ArrayList<Integer> order=new ArrayList<>();

    public SingleSourcePath(Graph G,int s){
        this.G=G;
        this.s=s;
        visited=new boolean[G.getV()];
        pre=new int[G.getV()];

        for(int i=0;i<pre.length;i++) pre[i]=-1;

        bfs(s);
    }

    private void bfs(int s){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=true;
        pre[s]=s;
        while(!queue.isEmpty()){
            int v=queue.poll();
            order.add(v);
            for(int w:G.adj(v)) if(!visited[w]) {
                queue.offer(w);
                visited[w]=true;
                pre[w]=v;
            }
        }
    }

    private boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t){
        List<Integer> res=new ArrayList<>();
        if(!visited[t]) return res;
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
        SingleSourcePath singleSourcePath=new SingleSourcePath(g,0);
        System.out.println(singleSourcePath.path(5));
    }
}
