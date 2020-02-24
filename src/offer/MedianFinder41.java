package offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder41 {

    Queue<Integer> minHeap=new PriorityQueue<>();
    Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);

    public MedianFinder41() {

    }

    /**
     * 借助两个堆进行完成，前半部分保存在最大堆中，后半部分保存在最小堆中
     * @param num
     */
    public void addNum(int num) {
        if(maxHeap.isEmpty()) maxHeap.add(num);
        else{
            if(num>maxHeap.peek()){
                minHeap.add(num);
                if(minHeap.size()>maxHeap.size()) maxHeap.add(minHeap.poll());
            }else{
                if(maxHeap.size()>minHeap.size()) minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if((minHeap.size()+maxHeap.size())%2==0)
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        else return maxHeap.peek();
    }

}
