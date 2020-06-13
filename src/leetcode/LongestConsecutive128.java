package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive128 {

    @Test
    public void test(){
        int[] nums={1,0,-1};
        solution(nums);
    }

    /**
     * 将所有元素加入到set后遍历
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int result=0,temp=0;
        Set<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        for(int num:nums){
            if(!set.contains(num-1)){
                temp=1;
                while(set.contains(num+1)){
                    temp+=1;
                    num++;
                }
            }
            result=Math.max(result,temp);
        }
        return result;
    }


}
