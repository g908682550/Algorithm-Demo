package sort;

import java.util.Arrays;
import java.util.Collections;

public class SelectSort {
    /**
     * 选择排序，依次找出后n-1个元素中最小的元素从头交换
     * @param nums
     */
    public static void selectSort(Comparable[] nums){
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int min_index=i;

            for(int j=i+1;j<n;j++)
                if(nums[j].compareTo(nums[min_index])<0) min_index=j;

            Collections.swap(Arrays.asList(nums),i,min_index);
        }
    }
}
