package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class CheckIfExist {

    @Test
    public void test(){
        int[] arr={-2,0,10,-19,4,6,-8};
        solution(arr);
    }


    int[] arr;

    public boolean solution(int[] arr){
        this.arr=arr;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            if(search(num*2)) return true;
        }
        return false;
    }

    public boolean search(int num){
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(arr[mid]<num){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(arr[left]==num) return true;
        else return false;
    }

}
