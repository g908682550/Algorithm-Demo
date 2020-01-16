package sort;

import java.util.Arrays;

//各类排序算法实现
public class Sort {

    public static void main(String[] args) {
        int[] nums={2,3,234,11,54,23,55,0,333,12,32,54,22};
//        int[] nums={1,2,3,4,5,6,7,0};
        int[] temp=new int[nums.length];
        MergeSort.MergeSort(nums,0,nums.length-1,temp);
        System.out.println(Arrays.toString(nums));
    }

}
