package leetcode;

import org.junit.Test;

import java.util.Stack;

public class IsValid20 {

    @Test
    public void test(){
        String s="()";
        System.out.println(solution(s));
    }

    public boolean solution(String s){
        Stack<Character> stack=new Stack<>();
        int length=s.length();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{') stack.push(c);
            else{
                if(stack.size()==0) return false;
                else{
                    if(c=='}'&&stack.peek()!='{') return false;
                    else if(c==']'&&stack.peek()!='[') return false;
                    if(c==')'&&stack.peek()!='(') return false;
                    stack.pop();
                }
            }
        }
        return stack.size()==0?true:false;
    }

}
