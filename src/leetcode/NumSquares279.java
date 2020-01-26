package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquares279 {


    @Test
    public void test(){
        solution2(12);
    }

    /**
     * 创建一个大小为n+1的数组，动态规划解决
     * @param n
     * @return
     */
    public int solution1(int n){
        int[] nums=new int[n+1];
        for(int i=1;i<n+1;i++){
            nums[i]=i;
            for(int j=1;i-j*j>=0;j++)//始终保证当前num[i]为最优解，即最少可能性
                nums[i]=Math.min(nums[i-j*j]+1,nums[i]);

        }
        return nums[n];
    }

    public int solution2(int n){
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(n,0));
        boolean[] flag=new boolean[n+1];//如果之前有相同的数字之前出现过，不必重新计算
        flag[n]=true;
        while(queue.size()>0){
            Pair pair=queue.poll();
            int num=pair.val;
            int step=pair.step;
            for(int i=1;;i++){
                int a=num-i*i;
                if(a<0) break;
                if(a==0) return step+1;
                if(!flag[a]){
                    queue.offer(new Pair(a,step+1));
                    flag[a]=true;
                }
            }
        }
        return -1;
    }


}

class Pair{
    int val;
    int step;
    public Pair(int val,int step){
        this.val=val;
        this.step=step;
    }
}
