package leetcode;

import org.junit.Test;

import java.util.Stack;

public class simplifyPath71 {

    @Test
    public void test(){
        String s="/a/../../b/../c//.//";
        System.out.println(solution(s));
    }

    public String solution(String path){
        String[] paths=path.split("/");
        Stack<String> stack=new Stack<>();
        int length=paths.length;
        for(int i=0;i<length;i++){
            String s=paths[i];
            if(s.equals("")||s.equals(".")) continue;
            else if(s.equals("..")){
                if(stack.size()>0) stack.pop();
                else continue;
            }
            else stack.push(s);
        }
        StringBuilder s=new StringBuilder();
        if(stack.isEmpty()) s.append("/");
        Stack<String> other=new Stack<>();
        while(!stack.isEmpty()) other.push(stack.pop());
        while(!other.isEmpty()){
            s.append("/");
            s.append(other.pop());
        }
        return s.toString();
    }

}
