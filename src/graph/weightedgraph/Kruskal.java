package graph.weightedgraph;

import unionfind.UnionFind6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal最小生成树算法，时间复杂度O(ElogE)，借助并查集
 */
public class Kruskal {

    private WeightedGraph G;

    private ArrayList<WeightedEdge> mst;

    public Kruskal(WeightedGraph G){
        this.G=G;
        this.mst=new ArrayList<>();

        CC cc=new CC(G);
        //连通分量大于1,不能生成树
        if(cc.count()>1) return;

        //将所有边加入集合中
        ArrayList<WeightedEdge> edges=new ArrayList<>();
        for(int v=0;v<G.getV();v++){
            for(int w:G.adj(v)) if(v<w) edges.add(new WeightedEdge(v,w,G.getWeight(v,w)));
        }

        //将边按权重排序
        Collections.sort(edges);

        //建立边数量的并查集
        UnionFind6 uf=new UnionFind6(G.getV());

        //按权重依次遍历
        for(WeightedEdge edge:edges){
            int v=edge.getV();
            int w=edge.getW();
            //如果两条边不属于一个集合，才进行添加
            if(!uf.isConnected(v,w)){
                mst.add(edge);
                uf.unionElements(v,w);
            }
        }
    }

    //集合中的边（当前的最短横切边）连接起来即为最小生成树
    public List<WeightedEdge> result(){
        return mst;
    }


    public static void main(String[] args) {
        WeightedGraph g=new WeightedGraph("gg.txt");
        Kruskal kruskal=new Kruskal(g);
        System.out.println(kruskal.result());
    }

}
