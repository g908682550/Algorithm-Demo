package sort;

import java.util.Arrays;
import java.util.Collections;

public class PopSort {
    /**
     * 冒泡排序
     * @param nums
     */
    public static void popSort(Comparable[] nums){
        int n=nums.length;
        for(int i=1;i<n;i++){//只需进行n-1次排序，最后一个元素不用排序。
            int flag=0;
            for(int j=0;j<n-i;j++){//j<n-i表示后i个元素已经有序，不必进行比较
                if(nums[j].compareTo(nums[j+1])>0) Collections.swap(Arrays.asList(nums),j,j+1);
                flag=1;
            }
            if(flag==0) break;
        }
    }
}
