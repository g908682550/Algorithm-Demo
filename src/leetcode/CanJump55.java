package leetcode;

public class CanJump55 {

    /**
     * 不断更新结尾限制
     * @param nums
     * @return
     */
    public boolean solution(int[] nums){
        int n=nums.length,tail=0;
        for(int i=0;i<n;i++){
            if(i>tail) return false;
            tail=Math.max(tail,i+nums[i]);
        }
        return true;
    }

}
