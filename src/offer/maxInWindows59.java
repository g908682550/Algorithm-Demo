package offer;

import org.junit.Test;

import java.util.*;

public class maxInWindows59 {


    @Test
    public void test(){
        int[] num={2,3,4,2,6,2,5,1};
        System.out.println(solution1(num, 0));
    }

    /**
     * 利用优先队列
     * @param nums
     * @param k
     * @return
     */
    public int[] solution1(int[] nums,int k){
        if(nums.length==0) return new int[]{};
        Queue<Integer> maxHeap=new PriorityQueue<>(k,(a, b)->b-a);
        for(int i=0;i<k;i++) maxHeap.add(nums[i]);
        List<Integer> result=new ArrayList<>();
        int i=0,j=k;
        while(j<nums.length){
            result.add(maxHeap.peek());
            maxHeap.remove(nums[i]);
            maxHeap.add(nums[j]);
            j++;
            i++;
        }
        result.add(maxHeap.peek());
        int[] res=new int[result.size()];
        for(int p=0;p<res.length;p++) res[p]=result.get(p);
        return res;
    }

    /**
     * 利用双端队列
     * @param nums
     * @param k
     * @return
     */
    public int[] solution2(int[] nums,int k){
        if(nums.length==0) return new int[]{};
        int[] res=new int[nums.length-k+1];
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0,j=0;i<nums.length;i++){
            if(!queue.isEmpty()&&i-queue.peek()>=k) queue.poll();
            while(!queue.isEmpty()&&nums[i]>nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
            if(i>=k-1) res[j++]=nums[queue.peek()];
        }
        return res;
    }

}
