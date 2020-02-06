package leetcode;

import java.util.*;

/**
 * 给一个5L桶和3L桶，求如何获得4L的水
 */
public class WaterPuzzle {

    boolean[] visited;
    int[] pre;
    int end=-1;
    public WaterPuzzle(){
        visited=new boolean[100];
        pre=new int[100];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            int a=curr/10,b=curr%10;
            List<Integer> nexts=new ArrayList<>();
            //给5L的桶装满
            nexts.add(5*10+b);
            //给3L的桶装满
            nexts.add(a*10+3);
            //倒掉5L桶里的水
            nexts.add(b);
            //倒掉3L桶里的水
            nexts.add(a*10);
            //a最多能向b桶中倒多少水
            int x=Math.min(a,3-b);
            nexts.add((a-x)*10+(b+x));
            //b最多能向a桶中倒多少水
            int y=Math.min(5-a,b);
            nexts.add((a+y)*10+(b-y));
            for(int next:nexts){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                    pre[next]=curr;
                    if(next%10==4||next/10==4) {
                        end=next;
                        return;
                    }
                }
            }
            if(end!=-1) break;
        }
    }

    public Iterable<Integer> result(){
        List<Integer> res=new ArrayList<>();
        if(end==-1) return res;
        int curr=end;
        while(curr!=0){
            res.add(0,curr);
            curr=pre[curr];
        }
        return res;
    }

    public static void main(String[] args) {
        WaterPuzzle waterPuzzle = new WaterPuzzle();
        System.out.println(waterPuzzle.result());
    }

}
