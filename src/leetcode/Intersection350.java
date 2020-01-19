package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersection350 {

    @Test
    public void test(){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(solution1(nums1, nums2)));
    }

    /**
     * 借助于两个map实现，先遍历数组1到map1，随后遍历数组2到map2，最后对map2的值赋值给int数组返回
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution1(int[] nums1,int[] nums2){
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for(int i:nums1) if(map1.containsKey(i)) map1.put(i,map1.get(i)+1); else map1.put(i,1);
        for(int i:nums2)
            if(map1.containsKey(i)&&map1.get(i)>0){
                if(map2.containsKey(i)) map2.put(i,map2.get(i)+1);
                else map2.put(i,1);
                map1.put(i,map1.get(i)-1);
            }
        int k=0;
        int[] result=new int[Math.min(nums1.length,nums2.length)];
        for(Map.Entry<Integer,Integer> entry:map2.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            while(value>0) {
                result[k++]=key;
                value--;
            }
        }
        return Arrays.copyOf(result,k);
    }

}
