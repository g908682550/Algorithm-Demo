package leetcode;

import java.util.Stack;

public class MyQueue232 {

    /**
     * pop时将栈元素全部弹出转移后，弹出队首元素再压回栈
     */
    class MyQueue1{
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int first;

        public MyQueue1() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void push(int x) {
            if(stack1.isEmpty()) first=x;
            stack1.push(x);
        }

        public int pop() {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
            int res=stack2.pop();
            if(!stack2.isEmpty()) first=stack2.peek();
            while(!stack2.isEmpty())
                stack1.push(stack2.pop());
            return res;
        }
        public int peek() {
            return first;
        }
        public boolean empty() {
            return stack1.isEmpty();
        }
    }

    /**
     * 借助stack2，每次压栈都保证stack1出队顺序为队列顺序
     */
    class MyQueue2{
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int first;

        public MyQueue2() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void push(int x) {
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
            stack2.push(x);
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
