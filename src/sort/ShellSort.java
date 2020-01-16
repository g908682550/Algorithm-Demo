package sort;

public class ShellSort {
    /**
     * 希尔排序
     * @param nums
     */
    private static void shellSort(int[] nums){
        int n=nums.length;
        for(int gap=n/2;gap>=1;gap/=2){
            for(int i=gap;i<n;i++){
                int insertValue=nums[i];
                int insertIndex=i-gap;
                while (insertIndex>=0&&insertValue<nums[insertIndex]){
                    nums[insertIndex+gap]=nums[insertIndex];
                    insertIndex-=gap;
                }
                nums[insertIndex+gap]=insertValue;
            }
        }
    }
}
