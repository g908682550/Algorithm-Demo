package graph.build;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 以邻接矩阵构建简单图，缺点：需要大量空间，且查找相邻节点的时间复杂度高
 */
public class AdjMatrix {

    private int V;

    private int E;

    private int[][] adj;

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public boolean hasEdge(int v,int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v][w]==1;
    }

    /**
     * 返回该点连接的所有点
     * @param v
     * @return
     */
    public List<Integer> adj(int v){
        validateVertex(v);
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<V;i++)
            if(adj[v][i]==1) res.add(i);
        return res;
    }

    public int degree(int v){
        return adj(v).size();
    }

    public AdjMatrix(String filename){
        File file=new File(filename);
        try(Scanner scanner=new Scanner(file)) {
            V=scanner.nextInt();
            if(V<0) throw new IllegalArgumentException("V must be non-negative");
            adj=new int[V][V];
            E=scanner.nextInt();
            if(E<0) throw new IllegalArgumentException("E must be non-negative");
            for(int i=0;i<E;i++){
                int a=scanner.nextInt();
                validateVertex(a);
                int b=scanner.nextInt();
                validateVertex(b);
                //判断自环边
                if(a==b) throw new IllegalArgumentException("Self Loop is Detected");
                //判断平行边
                if(adj[a][b]==1) throw new IllegalArgumentException("Parallel Edges are Detected");
                adj[a][b]=1;
                adj[b][a]=1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v){
        if(v<0||v>=V) throw new IllegalArgumentException("vertex"+v+"is invalid");
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("V=%d,E=%d\n",V,E));
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                sb.append(String.format("%d ",adj[i][j]));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix=new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }

}
