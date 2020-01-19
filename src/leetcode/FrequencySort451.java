package leetcode;

import org.junit.Test;

public class FrequencySort451 {

    @Test
    public void test(){
        String s="tree";
        System.out.println(solution1(s));
    }

    /**
     * 根据字母出现次数构造一个数组，随后逐步取出最大值的元素进行拼接
     * @param s
     * @return
     */
    public String solution1(String s){
        int[] nums=new int[255];
        StringBuilder result=new StringBuilder();
        for(char c:s.toCharArray()){
            nums[c]++;
        }
        while(findMaxValueIndex(nums)!=0){
            int index=findMaxValueIndex(nums);
            int count=nums[index];
            nums[index]=0;
            char c=(char)index;
            while(count>0) {
                result.append(c);
                count--;
            }
        }
        return result.toString();
    }
    public int findMaxValueIndex(int[] nums){
        int maxValue=0,maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxValue){
                maxValue=nums[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
