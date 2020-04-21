package leetcode;
import java.util.*;
public class SuperEggDrop887 {

    Map<String,Integer> map=new HashMap<>();

    /**
     * 记忆化搜索，K个鸡蛋，N层楼需要的次数等于子问题中最坏情况下扔鸡蛋的次数+1
     * @param K
     * @param N
     * @return
     */
    public int solution(int K,int N){
        return count(K,N);
    }

    private int count(int k,int n){
        String s=k+"&"+n;
        if(map.containsKey(s)) return map.get(s);
        if(n==0) return 0;
        if(k==1) return n;
        int res=n,left=1,right=n;
        while(left<right){
            int mid=(left+right)/2;
            int broken=count(k-1,mid-1);
            int not_broken=count(k,n-mid);
            if(broken<not_broken){
                left=mid+1;
                res=Math.min(res,not_broken+1);
            }else{
                right=mid;
                res=Math.min(res,broken+1);
            }
        }
        map.put(s,res);
        return res;
    }

    /**
     * dp[k][m]表示k个鸡蛋，仍m次能测出的最高层数
     * @param K
     * @param N
     * @return
     */
    public int solution2(int K,int N){
        int[][] dp=new int[K+1][N+1];
        int m=0;
        while(dp[K][m]<N){
            m++;
            for(int i=1;i<=K;i++){
                dp[i][m]=dp[i][m-1]+dp[i-1][m-1]+1;
            }
        }
        return m;
    }
}
