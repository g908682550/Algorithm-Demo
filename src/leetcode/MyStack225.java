package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack225 {

    /**
     * 借助两个队列实现，pop为O(n)级别，push和top为O(1)级别，始终保持一个队列，元素正常入队，弹出元素时将所有元素除了最后一个元素转移到另一个队列中，最后一个元素弹出
     */
    class MyStack1{
        Queue<Integer> q1;
        Queue<Integer> q2;
        int top;
        public MyStack1() {
            q1=new LinkedList<>();
            q2=new LinkedList<>();
        }
        public void push(int x) {
            q1.offer(x);
            top=x;
        }
        public int pop() {
            while(q1.size()>1){
                top=q1.remove();
                q2.offer(top);
            }
            int res=q1.poll();
            Queue<Integer> temp=q2;
            q2=q1;
            q1=temp;
            return res;
        }
        public int top() {
            return top;
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * 保证q1始终按栈顺序出队
     */
    class MyStack2{
        Queue<Integer> q1;
        Queue<Integer> q2;
        int top;
        public MyStack2() {
            q1=new LinkedList<>();
            q2=new LinkedList<>();
        }
        public void push(int x) {
            q2.offer(x);
            top=x;
            while(!q1.isEmpty()){
                q2.offer(q1.remove());
            }
            Queue<Integer> temp=q1;
            q1=q2;
            q2=q1;
        }
        public int pop() {
            int res=q1.remove();
            if(!q1.isEmpty()) top=q1.peek();
            return res;
        }
        public int top() {
            return top;
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * 一个队列，队列插入元素时让前面的元素加入到其后面
     */
    class MyStack3{
        Queue<Integer> queue;

        public MyStack3() {
            queue=new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            int size=queue.size();
            while(size-->1) queue.offer(queue.remove());
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

}
