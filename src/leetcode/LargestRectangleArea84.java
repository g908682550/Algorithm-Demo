package leetcode;

import org.junit.Test;

import java.util.*;

public class LargestRectangleArea84 {

    @Test
    public void test(){
        int[] nums={2,1,5,6,2,3};
        solution(nums);
    }

    public int solution(int[] heights){
        Deque<Integer> deque=new LinkedList<>();
        int res=0;
        for(int i=0;i<heights.length;i++){
            while(deque.size()!=0&&deque.peekLast()>heights[i]) deque.pollLast();
            deque.add(heights[i]);
            res=Math.max(res,deque.peek()*deque.size());
        }
        for(int i=heights.length-1;i>=0;i--){
            while(deque.size()!=0&&deque.peekLast()>heights[i]) deque.pollLast();
            deque.add(heights[i]);
            res=Math.max(res,deque.peek()*deque.size());
        }
        return res;
    }

}
