package offer;

import org.junit.Test;

public class ReversePairs51 {

    int[] temp;
    int res;

    @Test
    public void test(){
        int[] nums={7,5,6,4};
        solution(nums);
    }

    public int solution(int[] nums){
        int n=nums.length;
        if(n==0) return 0;
        temp=new int[n];
        mergeSort(nums,0,nums.length-1);
        return res;
    }

    public void mergeSort(int[] nums,int left,int right){
        if(left>=right) return;
        int mid=left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge1(nums,left,mid,right);
    }

    /**
     * 后面的小数归并时
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    public void merge1(int[] nums,int left,int mid,int right){
        int l=left,r=mid+1;
        for(int k=left;k<=right;k++) temp[k]=nums[k];
        for(int k=left;k<=right;k++){
            if(l==mid+1) nums[k]=temp[r++];
            else if(r==right+1) nums[k]=temp[l++];
            else if(temp[l]>temp[r]){
                res+=(mid-l+1);
                nums[k]=temp[r++];
            }else{
                nums[k]=temp[l++];
            }
        }
    }

    /**
     * 前面的小数归并时
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    public void merge2(int[] nums,int left,int mid,int right){
        int l=left,r=mid+1;
        for(int k=left;k<=right;k++) temp[k]=nums[k];
        for(int k=left;k<=right;k++){
            if(l==mid+1) nums[k]=temp[r++];
            else if(r==right+1) {
                nums[k]=temp[l++];
                res+=(r-mid-1);
            }
            else if(temp[l]<=temp[r]){
                nums[k]=temp[l++];
                res+=(r-mid-1);
            }else{
                nums[k]=temp[r++];
            }
        }
    }

}
