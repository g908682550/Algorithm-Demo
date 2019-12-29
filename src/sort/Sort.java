package sort;

import java.util.Arrays;

//各类排序算法实现
public class Sort {

    private static int count;

    public static void main(String[] args) {
//        int[] nums={2,3,234,11,54,23,55,0,333,12,32,54,22};
        int[] nums={1,2,3,4,5,6,7,0};
        int[] temp=new int[nums.length];
        MergeSort(nums,0,nums.length-1,temp);
        System.out.println(Arrays.toString(nums));
        System.out.println(count%1000000007);
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
     * 1.n个节点的二叉树一共有((2n)!)/(n! * (n+1)!)种
     * 2.n层二叉树的第n层最多为2^(n-1)个
     * 3.二叉树节点计算公式 N = n0+n1+n2，度为0的叶子节点比度为2的节点数多一个。N=1*n1+2*n2+1
     * 4.对任何一棵二叉树T，如果其终端节点数为n0，度为2的节点数为n2，则n0=n2+1
     * 5.具有n个节点的完全二叉树的深度为log2(n) + 1
     * @param nums
     */
    public static void heapSort(int[] nums){
        int n=nums.length;
        //下沉方式构造堆有序
        for(int i=n/2-1;i>=0;i--){//完全二叉树的第一个非叶子节点下标为n/2-1;左子节点为2k+1,右子节点为2k-1;调整位置为i的非叶子节点，调整完成后该子树有序，从右到左，从下到上，最后到根节点逐步有序
            adjustHeap(nums,i,n);
        }
        while(n>0){
            swap(nums,0,n-1);//有序堆的第一个元素最大，将其第一个元素交换到最后。
            adjustHeap(nums,0,--n);//对首元素进行一次下沉操作，构造新的有序堆
        }
    }

    public static void adjustHeap(int[] arr,int i,int length){
        while(2*i+1<length){//找到它的第一个左子节点
            int j=2*i+1;
            if(j+1<length&&arr[j+1]>arr[j]) j++;//是否存在右子节点，如果存在且右子节点大于左子节点，则将j指向右子节点
            if(arr[i]>arr[j]) break;//i元素大于了j元素，则返回,说明有序，不用判断其子树，因为子树已经为最大堆
            swap(arr,i,j);//如果i比两个子节点都小，将i与子节点最大值交换，交换后继续向下找合适的位置
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
            if(i>mid)                   nums[k]=temp[j++];
            else if(j>right)            nums[k]=temp[i++];
            else if(temp[i]>temp[j])    {
                nums[k]=temp[j++];
                count+=(mid-i+1);
            }
            else                        nums[k]=temp[i++];
        }
    }
}
