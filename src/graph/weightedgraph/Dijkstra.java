package graph.weightedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//时间复杂度(O(V*V))，优化后时间复杂度(O(ElogE))
public class Dijkstra {

    private WeightedGraph G;
    private int s;
    private int[] dis;
    private int[] pre;
    private boolean[] visited;

    /**
     * 创建一个内部类，保存节点以及源到该节点的距离
     */
    private class Node implements Comparable<Node>{
        public int v,dis;

        @Override
        public int compareTo(Node o) {
            return dis-o.dis;
        }

        public Node(int v, int dis){
            this.v=v;
            this.dis=dis;
        }
    }

    public Dijkstra(WeightedGraph g,int s){
        this.G=g;
        G.validateVertex(s);
        this.s=s;
        dis=new int[G.getV()];
        pre=new int[G.getV()];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        pre[s]=s;
        visited=new boolean[G.getV()];

        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(s,0));
        while(!pq.isEmpty()){
            //找到当前的最短边以及其顶点
            int currV=pq.poll().v;
//            使用优先队列优化此过程
//            for(int v=0;v<G.getV();v++){
//                if(!visited[v]&&dis[v]<currDis){
//                    currDis=dis[v];
//                    currV=v;
//                }
//            }
//            //说明全部已经确定
//            if(currV==-1) break;

            //当前顶点已经被确定了
            if(visited[currV]) continue;
            //当前顶点一定是最短路径
            visited[currV]=true;
            //遍历当前顶点所有未确定的顶点
            for(int w:G.adj(currV)){
                if(!visited[w]){
                    //更新距离，即从当前顶点出发到各个顶点的长度
                    if(dis[w]>dis[currV]+G.getWeight(currV,w)){
                        dis[w]=dis[currV]+G.getWeight(currV,w);
                        pq.offer(new Node(w,dis[w]));
                        pre[w]=currV;
                    }
                }
            }
        }
    }

    public boolean isConnected(int v){
        G.validateVertex(v);
        return visited[v];
    }

    public int disTo(int v){
        G.validateVertex(v);
        return dis[v];
    }

    public Iterable<Integer> path(int t){
        List<Integer> res = new ArrayList<>();
        if(!isConnected(t)) return res;
        int cur=t;
        while(cur!=s){
            res.add(0,cur);
            cur=pre[cur];
        }
        res.add(0,s);
        return res;
    }

    public static void main(String[] args){
        WeightedGraph g=new WeightedGraph("ggg.txt");
        Dijkstra dijkstra = new Dijkstra(g,0);
        for(int v=0;v<g.getV();v++){
            System.out.print(dijkstra.disTo(v)+" ");
        }
        System.out.println();
        System.out.println(dijkstra.path(3));
    }

}

