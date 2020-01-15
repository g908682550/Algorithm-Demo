package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Merge88 {

    @Test
    public void test(){
        int[] nums1={1,4,5,0,0,0,0};
        int[] nums2={2,2,3,4};
        solution3(nums1,3,nums2,4);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 暴力解法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void solution1(int[] nums1, int m, int[] nums2, int n){
        for(int k=m;k<m+n;k++) nums1[k]=nums2[k-m];
        Arrays.sort(nums1);
    }


    /**
     * 借助于额外数组的原地归并排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void solution2(int[] nums1, int m, int[] nums2, int n){
        int[] temp=new int[m];
        for(int i=0;i<m;i++) temp[i]=nums1[i];
        int i=0,j=0,k=0;
        while(i<m||j<n){
            if(i==m) nums1[k++]=nums2[j++];
            else if(j==n) nums1[k++]=temp[i++];
            else if(temp[i]<nums2[j]) nums1[k++]=temp[i++];
            else nums1[k++]=nums2[j++];
        }
    }

    /**
     *从后往前的归并排序，不需要借助额外空间
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void solution3(int[] nums1, int m, int[] nums2, int n){
        int k=m+n-1,i=m-1,j=n-1;
        while(i>=0||j>=0){
            if(j<0) break;
            else if(i<0) nums1[k--]=nums2[j--];
            else if(nums1[i]>nums2[j]) nums1[k--]=nums1[i--];
            else nums1[k--]=nums2[j--];
        }
    }
}

