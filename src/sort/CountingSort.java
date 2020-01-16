package sort;

public class CountingSort {
    /**
     * 计数排序
     * @param arr
     */
    public static void countingSort(int[] arr){
        countingSort1(arr,getMinValue(arr),getMaxValue(arr));
    }

    private static void countingSort1(int[] nums, int minValue,int maxValue) {
        int length=maxValue-minValue+1;
        int[] bucket=new int[length];
        for(int value:nums){
            bucket[value]++;
        }
        int i=0;
        for(int j=0;j<bucket.length;j++){
            while(bucket[j]>0){
                nums[i++]=j;
                bucket[j]--;
            }
        }
    }

    public static int getMaxValue(int[] nums){
        int maxValue=nums[0];
        for(int i:nums){
            if(i>maxValue) maxValue=i;
        }
        return maxValue;
    }
    public static int getMinValue(int[] nums){
        int minValue=nums[0];
        for(int i:nums){
            if(i<minValue) minValue=i;
        }
        return minValue;
    }
}
