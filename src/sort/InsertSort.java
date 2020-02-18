package sort;

public class InsertSort {
    /**
     * 插入排序
     * @param nums
     */
    public static void insertSort(Comparable[] nums){
        int n=nums.length;
        for(int i=1;i<n;i++){
            int insertValue=(int)nums[i];
            int insertIndex=i-1;
            while(insertIndex>=0&&nums[insertIndex].compareTo(insertValue)>0)
                nums[insertIndex+1]=nums[insertIndex--];
            nums[insertIndex+1]=insertValue;
        }
    }

    /**
     * 对left,right索引之间的数组进行插入排序
     * @param nums
     * @param left
     * @param right
     */
    public static void insertSort(Comparable[] nums,int left,int right){
        for(int i=left+1;i<=right;i++){
            int insertValue=(int)nums[i];
            int insertIndex=i-1;
            while(insertIndex>=0&&nums[insertIndex].compareTo(insertValue)>0) nums[insertIndex+1]=nums[insertIndex--];
            nums[insertIndex+1]=insertValue;
        }
    }
}
