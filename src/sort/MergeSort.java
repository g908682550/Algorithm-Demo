package sort;

public class MergeSort {
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
            if(i>mid)                   nums[k]=temp[j++];
            else if(j>right)            nums[k]=temp[i++];
            else if(temp[i]>temp[j])    nums[k]=temp[j++];
            else                        nums[k]=temp[i++];
        }
    }
}
