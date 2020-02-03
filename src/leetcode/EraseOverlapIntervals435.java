package leetcode;

import org.junit.Test;

public class EraseOverlapIntervals435 {

    @Test
    public void test(){
        int[][] nums={{-1,1},{10,11},{12,14},{3,4}};
        solution1(nums);
    }

    /**
     * 动态规划
     * @param intervals
     * @return
     */
    public int solution1(int[][] intervals){
        int n=intervals.length,maxLength=0;
        if(n==0) return 0;
        //对区间数组进行排序
        quickSort(intervals,0,n-1);
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++) if(intervals[i][0]>=intervals[j][1]) dp[i]=Math.max(dp[i],dp[j]+1);
            maxLength=Math.max(maxLength,dp[i]);//保存当前长度的最大值
        }
        return n-maxLength;
    }

    /**
     * 贪心算法
     * @param intervals
     * @return
     */
    public int solution2(int[][] intervals){
        int n=intervals.length,maxLength=1;
        if(n==0) return 0;
        quickSort(intervals,0,n-1);
        int[] pre=intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=pre[1]){
                maxLength++;
                pre=intervals[i];
            }
        }
        return n-maxLength;
    }

    public void quickSort(int[][] nums,int left,int right){
        if(left>=right) return;
        int partition=partition(nums,left,right);
        quickSort(nums,left,partition-1);
        quickSort(nums,partition+1,right);
    }

    public int partition(int[][] nums,int left,int right){
        int l=left,r=right+1,v=nums[left][0];
        while(true){
            while(nums[++l][0]<v) if(l==right) break;
            while(nums[--r][0]>v) if(r==left) break;
            if(l>=r) break;
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }

    public void swap(int[][] nums,int i,int j){
        int[] temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
