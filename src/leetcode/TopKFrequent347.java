package leetcode;

import org.junit.Test;

import java.util.*;
import javafx.util.Pair;

public class TopKFrequent347 {

    @Test
    public void test(){
        int[] nums={1,1,1,2,2,3};
        solution1(nums,2);
    }

    /**
     * 构建堆时直接使用map作为判断条件
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> solution1(int[] nums, int k){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,1)+1);
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k+1,(a, b)->map.get(a)-map.get(b));
        for(Integer i:map.keySet()){
            minHeap.add(i);
            if(minHeap.size()==k+1) minHeap.poll();
        }
        List<Integer> result=new ArrayList<>();
        while(minHeap.size()>0){
            result.add(minHeap.poll());
        }
        return result;
    }

    /**
     * 使用Pair的频率构建最小堆
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> solution2(int[] nums,int k){
        PriorityQueue<Pair<Integer,Integer>> minHeap=new PriorityQueue<>(k+1,(a,b)->a.getValue()-b.getValue());
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,1)+1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            Pair pair=new Pair(entry.getKey(),entry.getValue());
            minHeap.add(pair);
            if(minHeap.size()==k+1) minHeap.poll();
        }
        List<Integer> result=new ArrayList<>();
        while(minHeap.size()>0){
            result.add(minHeap.poll().getKey());
        }
        return result;
    }

}
