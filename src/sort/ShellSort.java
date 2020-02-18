package sort;

public class  ShellSort {
    /**
     * 希尔排序
     * @param nums
     */
    public static void shellSort(Comparable[] nums){
        int n=nums.length;
        //分别将数组分割成2、4、直到n个数组进行插入排序，插入排序在基本有序的情况下时间复杂度极低
        for(int gap=n/2;gap>=1;gap/=2){
            for(int i=gap;i<n;i++){
                int insertValue=(int)nums[i];
                int insertIndex=i-gap;
                while (insertIndex>=0&&nums[insertIndex].compareTo(insertValue)>0){
                    nums[insertIndex+gap]=nums[insertIndex];
                    insertIndex-=gap;
                }
                nums[insertIndex+gap]=insertValue;
            }
        }
    }
}
