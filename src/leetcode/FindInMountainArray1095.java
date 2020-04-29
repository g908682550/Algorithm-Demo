package leetcode;

import org.junit.Test;

public class FindInMountainArray1095 {

    @Test
    public void test(){
        int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,
                61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,
                91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82};
        solution(3,nums);
    }

    public int solution(int target, int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid]-1) left=mid+1;
            else right=mid;
        }
        int p=0,q=0,a=0,b=left,c=left,d=n-1;
        while(a<b){
            int mid=a+(b-a)/2;
            if(nums[mid]<target){
                a=mid+1;
            }else b=mid;
        }
        p=(nums[a]==target?a:-1);
        while(c<d){
            int mid=c+(d-c)/2;
            if(nums[mid]>target) c=mid+1;
            else d=mid;
        }
        q=(nums[c]==target?c:-1);
        if(p==-1&&q==-1) return -1;
        else return p==-1?q:p;

    }


}
