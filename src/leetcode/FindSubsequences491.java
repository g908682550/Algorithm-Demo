package leetcode;

import org.junit.Test;

import java.util.*;

public class FindSubsequences491 {

    @Test
    public void test(){
        int[] nums={4,6,7,7};
        List<List<Integer>> solution = solution(nums);
        System.out.println("...");
    }

    int[] nums;
    Set<List<Integer>> temp=new HashSet<>();

    public List<List<Integer>> solution(int[] nums){
        this.nums=nums;
        Arrays.sort(nums);
        for(int i=2;i<=nums.length;i++){
            for(int j=0;j<=nums.length-i;j++){
                helper(new ArrayList<>(),j,i);
            }
        }
        List<List<Integer>> result=new ArrayList<>(temp);
        return result;
    }

    public void helper(List<Integer> list,int index,int n){
        if(list.size()==n){
            temp.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        for(int i=index+1;i<nums.length;i++){
            helper(list,i,n);
        }
        list.remove(list.size()-1);
    }

}
