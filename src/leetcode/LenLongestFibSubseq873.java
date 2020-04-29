package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LenLongestFibSubseq873 {

    @Test
    public void test(){
        int[] A={2,4,7,8,9,10,14,15,18,23,32,50};
        solution(A);
    }

    public int solution(int[] A){
        int n=A.length,res=0;
        if(n==0) return 0;
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=i+1;j<n;j++){
                int next=A[i]+A[j],pre=A[j];
                count=2;
                while(search(A,next)!=-1){
                    int temp=next;
                    next+=pre;
                    pre=temp;
                    count++;
                }
            }
            res=Math.max(count,res);
        }
        return res;
    }

    public int search(int[] A,int target){
        int left=0,right=A.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(A[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return A[left]==target?left:-1;
    }

}
