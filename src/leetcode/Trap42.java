package leetcode;

import org.junit.Test;

public class Trap42 {

    @Test
    public void test(){
        int[] nums={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution3(nums));
    }

    /**
     *暴力法，每次都计算一次左右边界的最小值来计算当前位置能接到的雨水
     * @param height
     * @return
     */
    public int solution1(int[] height){
        int count=0;
        for(int i=0;i<height.length;i++){
            count+=currCount(height,i);//计算出当前位置能接到的雨水
        }
        return count;
    }
    public int currCount(int[] height,int index){
        int left=index,right=index,leftMax=height[index],rightMax=height[index],curr=height[index];
        while(left>=0){
            if(height[left]>leftMax) leftMax=height[left];
            left--;
        }
        while(right<height.length){
            if(height[right]>rightMax) rightMax=height[right];
            right++;
        }
        return Math.min(leftMax,rightMax)-curr;
    }

    /**
     * 开辟两个数组将左边界的最大值以及右边界的最大值分别保存起来，不用每次都遍历计算
     * @param height
     * @return
     */
    public int solution2(int[] height){
        int n=height.length,leftMax=0,rightMax=0,count=0;
        int[] leftMaxArr=new int[n];
        int[] rightMaxArr=new int[n];
        for(int i=0;i<n;i++){
            leftMax=Math.max(height[i],leftMax);
            leftMaxArr[i]=leftMax;
        }
        for(int i=n-1;i>=0;i--){
            rightMax=Math.max(height[i],rightMax);
            rightMaxArr[i]=rightMax;
        }
        for(int i=0;i<n;i++){
            count+=Math.min(leftMaxArr[i],rightMaxArr[i])-height[i];
        }
        return count;
    }

    /**
     * 使用两个常量来维护左边界的最大值和右边界的最大值，双指针遍历，当左边界最大值较小时计算左指针接水的数量，右边界最大值较小时计算右指针接水的数量。
     * @param height
     * @return
     */
    public int solution3(int[] height){
        if(height.length==0) return 0;
        int left=0,right=height.length-1,leftMax=height[left],rightMax=height[right],count=0;
        while(left<right){
            if(leftMax<rightMax){
                count+=leftMax-height[left];
                left++;
                leftMax=Math.max(leftMax,height[left]);//始终需维护左边界最大值
            }else{
                count+=rightMax-height[right];
                right--;
                rightMax=Math.max(rightMax,height[right]);
            }
        }
        return count;
    }

}
