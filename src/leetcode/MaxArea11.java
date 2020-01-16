package leetcode;

import org.junit.Test;

public class MaxArea11 {

    @Test
    public void test(){
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(solution1(height));
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int solution1(int[] height){
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
            max=Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }
}
