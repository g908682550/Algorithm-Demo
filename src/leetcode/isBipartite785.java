package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class isBipartite785 {

    @Test
    public void test(){
        int[][] graph={{1,3},{0,2},{1,3},{0,2}};
        solution(graph);
    }

    /**
     * BFS判断
     * @param graph
     * @return
     */
    public boolean solution(int[][] graph){
        int[] colors=new int[graph.length];
        for(int i=0;i<graph.length;i++) colors[i]=-1;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(colors[i]==-1){
                queue.offer(i);
                colors[i]=1;
                while(!queue.isEmpty()){
                    int v=queue.poll();
                    for(int w:graph[v]){
                        if(colors[w]==-1){
                            colors[w]=1-colors[v];
                            queue.offer(w);
                        }else{
                            if(colors[w]==colors[v]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    int[] colors;

    /**
     * dfs判断
     * @param graph
     * @return
     */
    public boolean solution2(int[][] graph){
        colors=new int[graph.length];
        for(int i=0;i<graph.length;i++) colors[i]=-1;
        for(int i=0;i<graph.length;i++)
            if(colors[i]==-1&&!dfs(graph,i,1)) return false;
        return true;
    }

    private boolean dfs(int[][] graph,int i,int color){
        colors[i]=color;
        for(int w:graph[i]){
            if(colors[w]==-1){
                if(!dfs(graph,w,1-color)) return false;
            }else{
                if(colors[w]==colors[i]) return false;
            }
        }
        return true;
    }

}
