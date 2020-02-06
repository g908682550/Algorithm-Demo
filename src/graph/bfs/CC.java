package graph.bfs;

import graph.build.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历求联通分量
 */
public class CC {

    private Graph G;
    private int[] visited;
    private int cccount;


    public CC(Graph G){
        this.G=G;
        visited=new int[G.getV()];
        for(int i=0;i<visited.length;i++) visited[i]=-1;

        for(int v=0;v<G.getV();v++){
            if(visited[v]==-1){
                cccount++;
                bfs(v,cccount);
            }

        }
    }

    public List<Integer>[] components(){
        ArrayList<Integer>[] res=new ArrayList[cccount];

        for(int i=0;i<cccount;i++) res[i]=new ArrayList<>();

        for(int v=0;v<G.getV();v++)
            res[visited[v]].add(v);

        return res;
    }

    public int count(){
        return cccount;
    }

    private void bfs(int s,int cccount){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=cccount;
        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int w:G.adj(v)) if(visited[w]==-1) {
                queue.offer(w);
                visited[w]=cccount;
            }
        }
    }


    public static void main(String[] args) {
        Graph g=new Graph("g.txt");
        GraphBFS graphBFS=new GraphBFS(g);
        System.out.println(graphBFS.order());
    }

}
