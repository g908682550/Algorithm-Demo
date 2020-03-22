package graph.weightedgraph;

import java.util.Arrays;

/**
 * 求所有点对的最短路径
 * 图的直径
 * 所有点对最短路径中的最大值
 * 可以包含负权边以及检测负权环
 */
public class Floyed {

    private WeightedGraph G;
    private int[][] dis;
    private boolean hasNegativeCycle=false;

    public Floyed(WeightedGraph G){
        this.G=G;
        dis=new int[G.getV()][G.getV()];
        //二维数组的初始化过程
        for(int i=0;i<G.getV();i++) Arrays.fill(dis[i],Integer.MAX_VALUE);
        //顶点自己到自己为0,到其它顶点的距离为权值
        for(int v=0;v<G.getV();v++){
            dis[v][v]=0;
            for(int w:G.adj(v)) dis[v][w]=G.getWeight(v,w);
        }
        for(int t=0;t<G.getV();t++)
            for(int v=0;v<G.getV();v++)
                for(int w=0;w<G.getV();w++)
                    if(dis[v][t]!=Integer.MAX_VALUE&&dis[t][w]!=Integer.MAX_VALUE&&dis[v][t]+dis[t][w]<dis[v][w])
                        dis[v][w]=dis[v][t]+dis[t][w];

        for(int v=0;v<G.getV();v++) if(dis[v][v]<0) hasNegativeCycle=true;
    }

    public boolean hasNegCycle(){
        return hasNegativeCycle;
    }

    public boolean isConnected(int v,int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return dis[v][w]!=Integer.MAX_VALUE;
    }

    public int disTo(int v,int w){
        return dis[v][w];
    }

    public static void main(String[] args) {
        WeightedGraph g=new WeightedGraph("ggg.txt");
        Floyed floyed = new Floyed(g);
        if(!floyed.hasNegCycle()){
            for(int v=0;v<g.getV();v++){
                for(int w=0;w<g.getV();w++)
                    System.out.print(floyed.disTo(v,w)+" ");
                System.out.println();
            }
        }
        else System.out.println("存在负权环");

    }

}
