package graph.weightedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//对所有边进行V-1轮的松弛操作,不能存在负权环，无向图中存在负权边则存在负权环
public class BellmanFord {

    private WeightedGraph G;
    private int s;
    private int[] dis;
    private boolean hasNegativeCycle=false;
    private int[] pre;

    public BellmanFord(WeightedGraph G,int s){
        this.G=G;
        G.validateVertex(s);
        this.s=s;

        dis=new int[G.getV()];
        pre=new int[G.getV()];
        Arrays.fill(pre,-1);
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        for(int pass=1;pass<G.getV();pass++)
            for(int v=0;v<G.getV();v++)
                for(int w:G.adj(v))
                    if(dis[v]!=Integer.MAX_VALUE&&dis[v]+G.getWeight(v,w)<dis[w])
                    {
                        dis[w]=dis[v]+G.getWeight(v,w);
                        pre[w]=v;
                    }
        for(int v=0;v<G.getV();v++)
            for(int w:G.adj(v))
                if(dis[v]!=Integer.MAX_VALUE&&dis[v]+G.getWeight(v,w)<dis[w]) hasNegativeCycle=true;


    }

    public boolean hasNegCycle(){
        return hasNegativeCycle;
    }

    public boolean isConnected(int v){
        G.validateVertex(v);
        return dis[v]!=Integer.MAX_VALUE;
    }

    public int disTo(int v){
        G.validateVertex(v);
        if(hasNegativeCycle) throw new RuntimeException("exist negative cycle.");
        return dis[v];
    }

    public Iterable<Integer> path(int t){
        List<Integer> res=new ArrayList<>();
        if(!isConnected(t)) return res;
        int curr=t;
        while(curr!=s){
            res.add(0,curr);
            curr=pre[curr];
        }
        res.add(0,s);
        return res;
    }

    public static void main(String[] args) {
        WeightedGraph G=new WeightedGraph("ggg.txt");
        BellmanFord bf=new BellmanFord(G,0);
        if(!bf.hasNegativeCycle){
            for(int v=0;v<G.getV();v++){
                System.out.print(String.format("%d ",bf.disTo(v)));
            }
            System.out.println();
            System.out.println(bf.path(3));
        }
        else System.out.println("存在负权环");
    }
}
