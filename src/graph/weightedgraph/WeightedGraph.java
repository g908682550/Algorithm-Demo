package graph.weightedgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class WeightedGraph {

    private int V;

    private int E;

    private TreeMap<Integer,Integer>[] adj;

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public boolean hasEdge(int v,int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].containsKey(w);
    }

    /**
     * 返回该点连接的所有点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v].keySet();
    }

    public int getWeight(int v,int w){
        if(hasEdge(v,w))
            return adj[v].get(w);
        else throw new IllegalArgumentException("error");
    }

    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    public WeightedGraph(String filename){
        File file=new File(filename);
        try(Scanner scanner=new Scanner(file)) {
            V=scanner.nextInt();
            if(V<0) throw new IllegalArgumentException("V must be non-negative");
            adj=new TreeMap[V];
            for(int i=0;i<V;i++)
                adj[i]=new TreeMap<>();

            E=scanner.nextInt();
            if(E<0) throw new IllegalArgumentException("E must be non-negative");
            for(int i=0;i<E;i++){
                int a=scanner.nextInt();
                validateVertex(a);
                int b=scanner.nextInt();
                validateVertex(b);
                int weight=scanner.nextInt();
                //判断自环边
                if(a==b) throw new IllegalArgumentException("Self Loop is Detected");
                //判断平行边
                if(adj[a].containsKey(b)) throw new IllegalArgumentException("Parallel Edges are Detected");
                adj[a].put(b,weight);
                adj[b].put(a,weight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object clone(){
        try{
            WeightedGraph cloned=(WeightedGraph) super.clone();
            cloned.adj=new TreeMap[V];
            for(int v=0;v<V;v++){
                cloned.adj[v]=new TreeMap<Integer, Integer>();
                for(Map.Entry<Integer,Integer> entry:adj[v].entrySet()){
                    cloned.adj[v].put(entry.getKey(),entry.getValue());
                }
            }
            return cloned;
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    public void validateVertex(int v){
        if(v<0||v>=V) throw new IllegalArgumentException("vertex"+v+"is invalid");
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("V=%d,E=%d\n",V,E));
        for(int i=0;i<V;i++){
            sb.append(String.format("%d: ",i));
            for(Map.Entry<Integer,Integer> w:adj[i].entrySet()) sb.append(String.format("(%d:%d)",w.getKey(),w.getValue()));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph("gg.txt");
        System.out.println(graph);
    }

}
