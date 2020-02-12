package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组（连续）数目。
 */
public class NumOfSubarrays5312 {

    @Test
    public void test(){
        int[] arr={11,13,17,23,29,31,7,5,2,3};
        solution(arr,3,5);
    }


    public int solution(int[] arr, int k, int threshold){
        int res=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length-k;i++){
            list.clear();
            for(int j=i;j<k+i;j++){
                list.add(arr[j]);
                if(valid(list,k*threshold)) res++;
            }
        }
        return res;
    }


    public boolean valid(List<Integer> list,int target){
        int sum=0;
        for(int i:list) sum+=i;
        if(sum>target) return true;
        else return false;
    }

}
