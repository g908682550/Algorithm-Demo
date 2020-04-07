package code_test;

import java.util.*;

public class B {
    static int[] score;
    static HashSet<Integer>[] graph;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        score=new int[n+1];
        graph=new HashSet[n+1];
        for(int i=1;i<=n;i++){
            score[i]=scanner.nextInt();
            graph[i]=new HashSet<>();
        }
        while(scanner.hasNextInt()){
            int u=scanner.nextInt(),v=scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        int max=0;
        for(int i=1;i<=n;i++){
            max=Math.max(helper(i),max);
        }
        System.out.println(max);
    }

    public static int helper(int num){
        int result=score[num];
        int max=0;
        for(int next:graph[num]){
            if(score[next]>result) max=Math.max(max,helper(next));
        }
        return result+max;
    }

}
