package leetcode;

import org.junit.Test;

import java.util.*;

public class Intersection349 {

    @Test
    public void test(){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(solution1(nums1, nums2)));
    }

    public int[] solution1(int[] nums1, int[] nums2){
        int n1=nums1.length,n2=nums2.length,j=0;
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        Set<Integer> rSet=new HashSet<>();
        for(int i:nums1) set.add(i);
        for(int i:nums2) if(set.contains(i)) rSet.add(i);
        int[] result=new int[rSet.size()];
        for(int i:rSet) result[j++]=i;
        return result;
    }

}
