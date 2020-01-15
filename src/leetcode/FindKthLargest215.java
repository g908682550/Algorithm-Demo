package leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

public class FindKthLargest215 {

    @Test
    public void test(){
        int[] nums={3,2,1,5,6,4};
        System.out.println(solution6(nums, 2));
    }

    /**
     * 借助于快速排序的切分法进行寻找,即找到排序后nums.length-k位置处的元素
     * @param nums
     * @param k
     * @return
     */
    public int solution1(int[] nums, int k){
        int target=nums.length-k;
        int left=0,right=nums.length-1;
        while(left<=right){
            if(left==right) return nums[left];
            int partition=partition(nums,left,right);
            if(partition==target) return nums[target];
            else if(partition<target) left=partition+1;
            else right=partition-1;
        }
        return -1;
    }

    public int partition(int[] nums,int left,int right){
        int l=left,r=right+1,partition=nums[left];
        while(true){
            while(nums[++l]<partition) if(l==right) break;
            while(nums[--r]>partition) if(r==left) break;
            if(l>=r) break;
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     *基于最小堆的实现
     * @param nums
     * @param k
     * @return
     */
    public int solution2(int[] nums, int k){
        int length=nums.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(length);
        for(int i:nums) minHeap.add(i);//将数组元素加入到最小堆中
        for(int i=0;i<length-k;i++) minHeap.poll();//从最小堆中弹出length-k个元素
        return minHeap.peek();//最小堆中的队头即为所求值
    }

    /**
     * 基于最大堆的实现
     * @param nums
     * @param k
     * @return
     */
    public int solution3(int[] nums, int k){
        int length=nums.length;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(length,(a,b)->b-a);
        for(int i:nums) maxHeap.add(i);
        for(int i=0;i<k-1;i++) maxHeap.poll();
//        //采用自己写的最大堆实现
//        queue.PriorityQueue maxHeap=new queue.PriorityQueue(length);
//        for(int i:nums) maxHeap.insert(i);
//        for(int i=0;i<k-1;i++) maxHeap.delMax();
        return maxHeap.peek();
    }

    /**
     * 构造一个仅为k大小的优先队列，保持队列头始终为当前遍历到的k个元素的最小值
     * @param nums
     * @param k
     * @return
     */
    public int solution4(int[] nums, int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
        for(int i=0;i<k;i++) minHeap.add(nums[i]);//先将前k个元素填进最小堆中
        for(int i=k;i<nums.length-1;i++){
            int topEle=minHeap.peek();//查看最小堆中的最小元素
            if(nums[i]>topEle){//如果当前数组元素大于最小堆的最小值，弹出后将数组元素加入其中，则队列始终为k个最大值
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    /**
     * 对解法4进行优化，直接构造出一个k+1大小的最小堆的优先队列，加入第k+1个元素时不用进行判断，优先队列自动修正
     * @param nums
     * @param k
     * @return
     */
    public int solution5(int[] nums, int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
        for(int i=0;i<k;i++) minHeap.add(nums[i]);
        for(int i=k;i<nums.length-1;i++){
            minHeap.add(nums[i]);
            minHeap.poll();
        }
        return minHeap.peek();
    }

    /**
     * k次冒泡排序得到，经过k次冒泡后，length-k处的元素即为第K大元素
     * @param nums
     * @param k
     * @return
     */
    public int solution6(int[] nums, int k){
        int length=nums.length;
        for(int i=1;i<=k;i++){
            for(int j=0;j<length-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums[length-k];
    }
}
