package sort;

public class MergeSort {
    /**
     * 归并排序，自顶向下归并
     */
    public static void MergeSort1(int[] nums,int left,int right,int[] temp){
        if(left>=right) return;
        int mid=(left+right)>>>1;
        MergeSort1(nums,left,mid,temp);
        MergeSort1(nums,mid+1,right,temp);
        merge(nums,left,mid,right,temp);
    }
    public static void merge(int[] nums,int left,int mid,int right,int[] temp){
        int i=left,j=mid+1;
        for(int k=left;k<=right;k++){
            temp[k]=nums[k];
        }
        for(int k=left;k<=right;k++){
            if(i>mid)                   nums[k]=temp[j++];
            else if(j>right)            nums[k]=temp[i++];
            else if(temp[i]>temp[j])    nums[k]=temp[j++];
            else                        nums[k]=temp[i++];
        }
    }

    /**
     * 归并排序，自底向上
     * @param nums
     * @param temp
     */
    public static void MergeSort2(int[] nums,int[] temp){
        int n=nums.length;
        for(int sz=1;sz<n;sz+=sz){
            for(int left=0;left<n-sz;left+=sz+sz){
                merge(nums,left,left+sz-1,Math.min(left+sz+sz-1,n-1),temp);
            }
        }
    }
}
