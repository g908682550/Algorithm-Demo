package leetcode;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class CanThreePartsEqualSum1013 {

    @Test
    public void test(){
        int[] A={18,12,-18,18,-19,-1,10,10};
        Queue<Integer> queue=new PriorityQueue<>();
        Object[] objects = queue.toArray();
    }

    public boolean solution(int[] A){
        int n=A.length;
        if(n==0) return false;
        int i=0,j=n-1,left_sum=0,right_sum=0;
        while(i+1<j){
            left_sum+=A[i++];
            while(j>i&&left_sum>right_sum){
                right_sum+=A[j--];
            }
            if(left_sum==right_sum){
                int mid=i,mid_sum=0;
                while(mid<=j) mid_sum+=A[mid++];
                if(mid_sum==left_sum) return true;
            }
        }
        return false;
    }

}
