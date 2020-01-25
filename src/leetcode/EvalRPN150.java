package leetcode;

import org.junit.Test;

import java.util.Stack;

public class EvalRPN150 {


    @Test
    public void test(){
        String[] tokens={"4", "13", "5", "/", "+"};
        System.out.println(solution(tokens));
    }


    public int solution(String[] tokens){
        Stack<Integer> stack=new Stack<>();
        int length=tokens.length;
        for(int i=0;i<length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                int num=0;
                if(tokens[i].equals("+")) num=a+b;
                else if(tokens[i].equals("-")) num=a-b;
                else if(tokens[i].equals("*")) num=a*b;
                else num=a/b;
                stack.push(num);
            }else
                stack.push(Integer.parseInt(tokens[i]));

        }
        return stack.pop();
    }
}
