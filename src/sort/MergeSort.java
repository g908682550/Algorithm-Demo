package sort;

/**
 * 性能测试，随机数据，百万级别(0.3s，250W级别之内能控制在1s),一千万级别（3s），一亿级别(55s)，需要额外空间
 */
public class MergeSort {
    /**
     * 归并排序，自顶向下归并
     */
    public static void MergeSort(Comparable[] nums,int left,int right,Comparable[] temp){
        if(left>=right) return;
        //可选优化，数组长度小于15采用插入排序效率更高
        if(right-left<=15){
            InsertSort.insertSort(nums,left,right);
            return;
        }
        int mid=left+(right-left)/2;
        MergeSort(nums,left,mid,temp);
        MergeSort(nums,mid+1,right,temp);

        //可选优化，如果当前数组左右数组已经有序，直接返回
        if(nums[mid].compareTo(nums[mid+1])<0) return;

        merge(nums,left,mid,right,temp);
    }
    public static void merge(Comparable[] nums,int left,int mid,int right,Comparable[] temp){
        int i=left,j=mid+1;
        //先将数组拷贝到临时数组中
        for(int k=left;k<=right;k++)
            temp[k]=nums[k];
        //依次从临时数组拷回原数组
        for(int k=left;k<=right;k++){
            if(i>mid)                                nums[k]=temp[j++];
            else if(j>right)                         nums[k]=temp[i++];
            else if(temp[i].compareTo(temp[j])>0)    nums[k]=temp[j++];
            else                                     nums[k]=temp[i++];
        }
    }

    /**
     * 归并排序，自底向上
     * @param nums
     * @param temp
     */
    public static void MergeSort2(Comparable[] nums,Comparable[] temp){
        int n=nums.length;
        for(int len=1;len<n;len+=len)//共进行lgN次循环,len为1,2，4,8..n(n为2的n次方),len*2为子数组大小
            for(int left=0;left<n-len;left+=len+len)//子数组,left每次递增len*2;
                merge(nums,left,left+len-1,Math.min(left+len+len-1,n-1),temp);
    }

}
