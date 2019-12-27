package sort;

import java.util.Arrays;

//各类排序算法实现
public class Sort {
    public static void main(String[] args) {
        int[] nums={2,3,234,11,54,23,55,0,333,12,32,54,22};
        heapSort(nums);
        int[] temp=new int[nums.length];
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
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
            while(nums[++l]<partition) if(l>=right) break;
            while(nums[--r]>partition) if(r<=left) break;
            if(l>=r) break;
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void popSort(int[] nums){
        int n=nums.length;
        for(int i=1;i<n;i++){
            int flag=0;
            for(int j=0;j<n-i;j++){
                if(nums[j]>nums[j+1]) swap(nums,j,j+1);
                flag=1;
            }
            if(flag==0) break;
        }
    }

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

    /**
     * 堆排序
     * @param nums
     */
    public static void heapSort(int[] nums){
        int n=nums.length;
        for(int i=n/2-1;i>=0;i--){
            adjustHeap(nums,i,n);
        }
        while(n>0){
            swap(nums,0,n-1);
            adjustHeap(nums,0,--n);
        }
    }

    public static void adjustHeap(int[] arr,int i,int length){
        while(2*i+1<length){
            int j=2*i+1;
            if(j+1<length&&arr[j+1]>arr[j]) j++;
            if(arr[i]>arr[j]) break;
            swap(arr,i,j);
            i=j;
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }

    /**
     * 归并排序
     */
    public static void MergeSort(int[] nums,int left,int right,int[] temp){
        if(left>=right) return;
        int mid=(left+right)>>>1;
        MergeSort(nums,left,mid,temp);
        MergeSort(nums,mid+1,right,temp);
        Merge(nums,left,mid,right,temp);
    }
    public static void Merge(int[] nums,int left,int mid,int right,int[] temp){
        int i=left,j=mid+1;
        for(int k=left;k<=right;k++){
            temp[k]=nums[k];
        }
        for(int k=left;k<=right;k++){
            if(i>mid) nums[k]=temp[j++];
            else if(j>right) nums[k]=temp[i++];
            else if(temp[i]>temp[j]) nums[k]=temp[j++];
            else nums[k]=nums[i++];
        }
    }
}
