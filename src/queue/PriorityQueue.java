package queue;

/**
 * 基于堆的优先队列简易实现
 */
public class PriorityQueue {
    private int[] nums;
    private int N=0;
    public PriorityQueue(int maxN){
        nums=new int[maxN];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(int k){
        nums[N++]=k;
        swim(N);
    }
    public int delMax(){
        int max=nums[0];
        swap(0,N--);
        nums[N+1]=0;
        sink(0);//恢复堆的有序性
        return max;
    }
    private boolean less(int i,int j){
        return nums[i]-nums[j]<0;
    }
    private void swap(int i,int j){
        int temp=nums[i];
        nums[j]=nums[i];
        nums[i]=temp;
    }

    //上浮操作
    private void swim(int k){
        while(k>0&&less((k-1)/2,k)){
            swap((k-1)/2,k);
            k=k/2;
        }
    }
    //下沉操作
    private void sink(int k){
        while(2*k+1<=N){
            int j=2*k+1;
            if(j+1<N&&nums[j+1]>nums[j]) j++;
            if(nums[k]>nums[j]) break;
            swap(k,j);
            k=j;
        }
    }
}
