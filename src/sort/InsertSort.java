package sort;

public class InsertSort {
    /**
     * 插入排序
     * @param nums
     */
    public static void insertSort(int[] nums){
        int n=nums.length;
        for(int i=1;i<n;i++){
            int insertValue=nums[i];
            int insertIndex=i-1;
            while(insertIndex>=0&&insertValue<nums[insertIndex]){
                nums[insertIndex+1]=nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex+1]=insertValue;
        }
    }
}
