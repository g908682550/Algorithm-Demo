package code_test;

import java.util.Arrays;

public class ArrayList1{

    int[] nums;
    private int size;

    int defaultSize=10;

    public ArrayList1(int num){
        nums=new int[num];
    }

    public void add(int e){
        ensureSize(size+1);
        nums[size++]=e;
    }

    public int set(int index,int e){
        int oldValue=nums[index];
        nums[index]=e;
        return oldValue;
    }

    public void ensureSize(int len){
        if(len>=nums.length){
            int old_len=nums.length;
            int new_len=old_len+(old_len>>1);
            nums=Arrays.copyOf(nums,new_len);
        }
    }

}
