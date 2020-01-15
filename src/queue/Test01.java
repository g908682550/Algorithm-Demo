package queue;

import java.util.HashMap;

public class Test01 {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(6);
        priorityQueue.insert(4);
        priorityQueue.insert(7);
        priorityQueue.insert(5);
        priorityQueue.insert(9);
        priorityQueue.insert(2);
        priorityQueue.insert(1);
        System.out.println(priorityQueue.Max());
        priorityQueue.delMax();
        System.out.println(priorityQueue.Max());
    }
}
