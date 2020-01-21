package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount454 {

    @Test
    public void test(){
        int[] A={1,2};
        int[] B={-2,-1};
        int[] C={-1,2};
        int[] D={0,2};
        System.out.println(solution1(A, B, C, D));
    }


    /**
     * 将C和D的和放入map中，再遍历A,B从map中获取另一个值
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int solution1(int[] A, int[] B, int[] C, int[] D){
        int n=A.length,result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=C[i]+D[j];
                if(map.containsKey(num)) map.put(num,map.get(num)+1);
                else map.put(num,1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int target=-A[i]-B[j];
                if(map.containsKey(target)) result+=map.get(target);
            }
        }
        return result;
    }

}
