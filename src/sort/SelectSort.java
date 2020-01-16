package sort;

public class SelectSort {
    /**
     * 选择排序
     * @param nums
     */
    public static void selectSort(int[] nums){
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int min=nums[i],min_index=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<min){
                    min=nums[j];
                    min_index=j;
                }
            }
            swap(nums,i,min_index);
        }
    }
    private static void swap(int[] nums, int l, int r) {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}
