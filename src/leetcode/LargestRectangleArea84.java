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
        List<Integer> list=new ArrayList<>();
        for(int num:heights) list.add(num);
        list.add(0);
        Stack<Integer> stack=new Stack<>();
        int res=0;
        for(int i=0;i<list.size();i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>list.get(i)){
                int width=heights[stack.pop()];
                res=Math.max(res,width*(stack.isEmpty()==true?i:i-stack.peek()-1));
            }
            stack.push(i);
        }
        return res;
    }

}
