package sort;

import java.util.Random;

//各类排序算法实现
public class Sort {

    public static void main(String[] args) {
        Comparable[] arr= new Comparable[10000000];
        Random random=new Random();
        for(int i=0;i<10000000;i++){
            arr[i]=random.nextInt(10000000);
        }
        long currentTimeMillis = System.currentTimeMillis();
//        InsertSort.insertSort(arr);
//        SelectSort.selectSort(arr);
//        ShellSort.shellSort(arr);
//        PopSort.popSort(arr);
//        MergeSort.MergeSort2(arr,new Comparable[arr.length]);
//        QuickSort.quickSort(arr,0,arr.length-1);
        HeapSort.heapSort(arr);
        long nextTimeMills=System.currentTimeMillis();
        System.out.println(nextTimeMills - currentTimeMillis);
//        System.out.println(Arrays.toString(arr));
    }

}
