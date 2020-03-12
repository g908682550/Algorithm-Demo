package leetcode;

import org.junit.Test;

public class MajorityElement169 {

    @Test
    public void test(){
        int[] nums={4,5,4};
        System.out.println(solution(nums));
    }

    public int solution(int[] nums){
        int n=nums.length;
        int left=0,right=n-1;
        while(true){
            if(left==right) return nums[left];
            int partition=partition(nums,left,right);
            if(partition==n/2) return nums[partition];
            else if(partition>n/2) right=partition-1;
            else left=partition+1;
        }
    }

    public int partition(int[] nums,int left,int right){
        int l=left,r=right+1,v=nums[left];
        while(true){
            while(nums[++l]<v) if(l==right) break;
            while(nums[--r]>v) if(r==left) break;
            if(l>=r) break;
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
