package leetcode;

public class FindErrorNums645 {

    /**
     * 让出现过数字的下标代表的数字为负数，若后续遍历为一个负数则代表当前数字出现过
     * 在遍历一遍，当前索引的数字为正值代表索引数字未出现过
     * 由于题目中为1到n的整数，需要对整数做一次处理
     * @param nums
     * @return
     */
    public int[] solution(int[] nums){
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            int curr=Math.abs(nums[i])-1;
            if(nums[curr]<0) a=curr+1;
            else nums[curr]=-nums[curr];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) b=i+1;
        }
        return new int[]{a,b};
    }

}
