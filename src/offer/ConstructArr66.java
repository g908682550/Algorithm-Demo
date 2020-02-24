package offer;

import java.util.Arrays;

public class ConstructArr66 {

    /**
     * 从左向右遍历一次计算出该值左边所有元素乘积。再从右向左遍历一次计算出最终结果
     * @param a
     * @return
     */
    public int[] solution(int[] a){
        int n=a.length;
        if(n==0) return new int[]{};
        int[] B=new int[n];
        Arrays.fill(B,1);
        for(int i=1;i<n;i++) B[i]=B[i-1]*a[i-1];
        int right=a[n-1];
        for(int i=n-2;i>=0;i--) {
            B[i]=B[i]*right;
            right=right*a[i];
        }
        return B;
    }

}
