package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历求两点路径
 */
public class Path {

    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;
    private int t;

    private ArrayList<Integer> order=new ArrayList<>();

    public Path(Graph G,int s,int t){
        this.G=G;
        this.s=s;
        this.t=t;
        visited=new boolean[G.getV()];
        pre=new int[G.getV()];

        for(int i=0;i<pre.length;i++) pre[i]=-1;

        bfs(s,t);
    }

    private void bfs(int s,int t){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=true;
        pre[s]=s;
        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int w:G.adj(v)) if(!visited[w]) {
                if(visited[t]) break;
                queue.offer(w);
                visited[w]=true;
                pre[w]=v;
            }
            if(visited[t]) break;
        }
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
        Graph g=new Graph("g.txt");
        Path path=new Path(g,0,5);
        System.out.println(path.path());
    }


}
