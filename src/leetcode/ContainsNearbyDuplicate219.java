package leetcode;

import org.junit.Test;

import java.util.*;

public class ContainsNearbyDuplicate219 {

    @Test
    public void test(){
        int[] nums={1,0,1,1};
        solution1(nums,1);
    }

    /**
     * 从头向后遍历，将元素放入map中，分别进行比较
     * @param nums
     * @param k
     * @return
     */
    public boolean solution1(int[] nums,int k){
        int n=nums.length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int curr=nums[i];
            if(map.containsKey(curr)){
                List<Integer> list=map.get(curr);
                for(Integer j:list)
                    if(Math.abs(j-i)<=k) return true;
                list.add(i);
                map.put(curr,list);

            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(curr,list);
            }
        }
        return false;
    }

    /**
     * 借助于set的滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public boolean solution2(int[] nums,int k){
        int n=nums.length,i=0,j=0;
        Set<Integer> set=new HashSet<>();
        while(j<n){
            if(j<=i+k)
                if(set.contains(nums[j])) return true;
                else set.add(nums[j++]);
            else set.remove(nums[i++]);
        }
        return false;
    }

}
