package sort;

import java.util.Arrays;
import java.util.Collections;

public class HeapSort {
    /**
     * 堆排序
     * 1.n个节点的二叉树一共有((2n)!)/(n! * (n+1)!)种
     * 2.n层二叉树的第n层最多为2^(n-1)个
     * 3.二叉树节点计算公式 N = n0+n1+n2，度为0的叶子节点比度为2的节点数多一个。N=1*n1+2*n2+1
     * 4.对任何一棵二叉树T，如果其终端节点数为n0，度为2的节点数为n2，则n0=n2+1
     * 5.具有n个节点的完全二叉树的深度为log2(n) + 1
     * @param nums
     */
    public static void heapSort(Comparable[] nums){
        int n=nums.length;
        //下沉方式构造堆有序（最大堆）
        for(int i=n/2-1;i>=0;i--)//完全二叉树的第一个非叶子节点下标为n/2-1;左子节点为2k+1,右子节点为2k-1;调整位置为i的非叶子节点，调整完成后该子树有序，从右到左，从下到上，最后到根节点逐步有序
            sink(nums,i,n);

        while(n>0){
            Collections.swap(Arrays.asList(nums),0,n-1);//有序堆的第一个元素最大，将其第一个元素交换到最后。
            sink(nums,0,--n);//对首元素进行一次下沉操作，构造新的有序堆
        }
    }

    public static void sink(Comparable[] arr,int i,int length){
        while(2*i+1<length){//找到它的第一个左子节点
            int j=2*i+1;
            if(j+1<length&&arr[j+1].compareTo(arr[j])>0) j++;//是否存在右子节点，如果存在且右子节点大于左子节点，则将j指向右子节点
            if(arr[i].compareTo(arr[j])>0) break;//i元素大于了j元素，则返回,说明有序，不用判断其子树，因为子树已经为最大堆
            Collections.swap(Arrays.asList(arr),i,j);//如果i比两个子节点都小，将i与子节点最大值交换，交换后继续向下找合适的位置
            i=j;
        }
    }

}
