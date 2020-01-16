package sort;

public class QuickSort {
    /**
     * 快速排序
     * @param nums
     */
    public static void quickSort(int[] nums,int left,int right) {
        if (left >= right) return;
        int j = partition(nums,left,right);
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }

    private static int partition(int[] nums, int left, int right) {
        int l=left,r=right+1,partition=nums[left];
        while(true){
            while(nums[++l]<partition) if(l==right) break;//从左边往右找到第一个大于切分元素的元素
            while(nums[--r]>partition) if(r==left) break;//从右边往左找到第一个小于切分元素的元素
            if(l>=r) break;
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }
    private static void swap(int[] nums, int l, int r) {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}
