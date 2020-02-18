package queue;

/**
 * 基于堆的优先队列简易实现,最大堆
 */
public class  PriorityQueue {

    private int[] nums;
    //当前队列中的元素
    private int N=0;

    public PriorityQueue(int maxN){

        nums=new int[maxN];

    }
    public void insert(int k){
        if(N==nums.length) throw new ArrayIndexOutOfBoundsException("队列已满");
        nums[N]=k;
        if(N<nums.length) N++;
        swim(N-1);//将刚才插入的元素上浮
    }

    public int delMax(){
        int max=nums[0];
        //将末尾元素与头节点交换
        swap(0,N-1);
        nums[N-1]=0;
        N--;

        sink(0);//下沉恢复堆的有序性
        return max;
    }

    public int Max(){
        return nums[0];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N+1;
    }

    //上浮操作
    private void swim(int k){
        while(k>0&&less((k-1)/2,k)){
            swap((k-1)/2,k);
            k=(k-1)/2;
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

    private boolean less(int i,int j){
        return nums[i]-nums[j]<0;
    }
    private void swap(int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
