package leetcode;

import org.junit.Test;

public class FindMedianSortedArrays4 {

    @Test
    public void test(){
        int[] nums1={1,3},nums2={2};
        System.out.println(solution(nums1, nums2));
    }

    /**
     * 计算两个数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution(int[] nums1,int[] nums2){
        int n=nums1.length+nums2.length;
        //left和right分别为数组总和的第几位数（从1开始）
        int left=(n+1)/2,right=(n+2)/2;
        return (helper(nums1,0,nums1.length-1,nums2,0,nums2.length-1,left)
                +helper(nums1,0,nums1.length-1,nums2,0,nums2.length-1,right))/2;
    }

    public double helper(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1=end1-start1+1,len2=end2-start2+1;
        if(len1>len2) return helper(nums2,start2,end2,nums1,start1,end1,k);
        if(len1==0) return nums2[start2+k-1];
        if(k==1) return Math.min(nums1[start1],nums2[start2]);
        int i=start1+Math.min(k/2,len1)-1;
        int j=start2+Math.min(k/2,len2)-1;
        if(nums1[i]<nums2[j]) return helper(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        else return helper(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
    }

}
