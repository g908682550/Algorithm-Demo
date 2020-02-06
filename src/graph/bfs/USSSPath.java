package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 无权图最短路劲问题
 */
public class USSSPath {

    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;
    private int[] dis;

    private ArrayList<Integer> order=new ArrayList<>();

    public USSSPath(Graph G,int s){
        this.G=G;
        this.s=s;
        visited=new boolean[G.getV()];
        pre=new int[G.getV()];
        dis=new int[G.getV()];
        for(int i=0;i<pre.length;i++) {
            pre[i]=-1;
            dis[i]=-1;
        }

        bfs(s);

        for(int i=0;i<G.getV();i++){
            System.out.println(dis[i]+" ");
        }
        System.out.println();
    }

    private void bfs(int s){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=true;
        pre[s]=s;
        dis[s]=0;
        while(!queue.isEmpty()){
            int v=queue.poll();
            order.add(v);
            for(int w:G.adj(v)) if(!visited[w]) {
                queue.offer(w);
                visited[w]=true;
                pre[w]=v;
                dis[w]=dis[v]+1;
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

    public int dis(int t){
        G.validateVertex(t);
        return dis[t];
    }


    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        USSSPath usssPath=new USSSPath(g,0);
    }


}
