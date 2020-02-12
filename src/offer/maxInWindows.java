package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class maxInWindows {


    @Test
    public void test(){
        int[] num={2,3,4,2,6,2,5,1};
        System.out.println(solution(num, 0));
    }

    public List<Integer> solution(int[] num,int size){
        ArrayList<Integer> result=new ArrayList<>();
        if(size>num.length) return result;
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(size,(a, b)->b-a);
        for(int i=0;i<size;i++) maxheap.add(num[i]);
        int j=size,i=0;
        while(j<num.length){
            result.add(maxheap.peek());
            maxheap.remove(num[i++]);
            maxheap.add(num[j++]);
        }
        return result;
    }

}
