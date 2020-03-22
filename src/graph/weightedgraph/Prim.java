package graph.weightedgraph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Prim最小生成树算法，时间复杂度O(ElogE),借助优先队列
public class Prim {

    private WeightedGraph G;

    private ArrayList<WeightedEdge> mst;

    public Prim(WeightedGraph G){
        this.G=G;
        mst=new ArrayList<>();

        CC cc=new CC(G);
        if(cc.count()>1) return;

        //Prim
        //判断当前点是否被遍历过，true和false将图分成两个集合
        boolean[] visited=new boolean[G.getV()];
        visited[0]=true;

        //使用优先队列来获取当前连通的最小带权边
        Queue<WeightedEdge> queue=new PriorityQueue<>();
        for(int w:G.adj(0)) queue.offer(new WeightedEdge(w,0,G.getWeight(w,0)));
        while(!queue.isEmpty()){
            WeightedEdge minEdge = queue.poll();
            if(visited[minEdge.getW()]&&visited[minEdge.getV()]) continue;
            mst.add(minEdge);
            int newv=visited[minEdge.getV()]?minEdge.getW():minEdge.getV();
            visited[newv]=true;
            for(int w:G.adj(newv)) if(!visited[w]) queue.offer(new WeightedEdge(newv,w,G.getWeight(newv,w)));
        }

//        for(int i=0;i<G.getV()-1;i++){
//            WeightedEdge minEdge=new WeightedEdge(-1,-1,Integer.MAX_VALUE);
//            //找到当前连通的最小带权边
//            for(int v=0;v<G.getV();v++){
//                if(visited[v]){
//                    for(int w:G.adj(v)){
//                        if(!visited[w]&&G.getWeight(v,w)<minEdge.weight)
//                            minEdge=new WeightedEdge(v,w,G.getWeight(v,w));
//                    }
//                }
//            }
//            mst.add(minEdge);
//            visited[minEdge.getV()]=true;
//            visited[minEdge.getW()]=true;
//        }

    }

    public List<WeightedEdge> result(){
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph weightedGraph=new WeightedGraph("gg.txt");
        Prim prim=new Prim(weightedGraph);
        System.out.println(prim.result());
    }

}
