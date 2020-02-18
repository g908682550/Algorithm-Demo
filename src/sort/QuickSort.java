package sort;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    /**
     * 快速排序
     * @param nums
     */
    public static void quickSort(Comparable[] nums,int left,int right) {
        if (left >= right) return;
        int j = partition(nums,left,right);
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }

    private static int partition(Comparable[] nums, int left, int right) {
        int l=left,r=right+1,partition= (int) nums[left];
        while(true){
            while(nums[++l].compareTo(partition)<0) if(l==right) break;//从左边往右找到第一个大于切分元素的元素
            while(nums[--r].compareTo(partition)>0) if(r==left) break;//从右边往左找到第一个小于切分元素的元素
            if(l>=r) break;
            Collections.swap(Arrays.asList(nums),l,r);
        }
        Collections.swap(Arrays.asList(nums),left,r);
        return r;
    }

}
