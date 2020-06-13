package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

    @Test
    public void test(){
        int[] T={89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(solution1(T)));
    }

    /**
     * 暴力解法
     * @param T
     * @return
     */
    public int[] solution1(int[] T){
        int n=T.length;
        int[] result=new int[n];
        result[n-1]=0;
        for(int i=0;i<n-1;i++){
            int curr=T[i],j=i+1;
            while(j<n&&T[j]<=curr) j++;
            if(j!=n) result[i]=j-i;
        }
        return result;
    }

    /**
     * 单调栈
     * @param T
     * @return
     */
    public int[] solution2(int[] T){
        int n=T.length;
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int temp=stack.pop();
                result[temp]=i-temp;
            }
            stack.push(i);
        }
        return result;
    }



}
