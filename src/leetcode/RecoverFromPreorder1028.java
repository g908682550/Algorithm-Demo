package leetcode;

import org.junit.Test;

import java.util.Stack;

public class RecoverFromPreorder1028 {

    @Test
    public void test(){
        String s="1-2--3--4-5--6--7";
        solution(s);
    }

    public TreeNode solution(String S) {
        int n=S.length();
        Stack<TreeNode> stack=new Stack<>();
        int pos=0;
        while(pos<n){
            int level=0;
            while(S.charAt(pos)=='-'){
                pos++;
                level++;
            }
            StringBuilder num=new StringBuilder();
            while(pos<n&&S.charAt(pos)!='-'){
                num.append(S.charAt(pos));
                pos++;
            }
            TreeNode node=new TreeNode(Integer.parseInt(num.toString()));
            if(level==stack.size()){
                if(!stack.isEmpty()) stack.peek().left=node;
            }else{
                while(level!=stack.size()){
                    stack.pop();
                }
                stack.peek().right=node;
            }
            stack.push(node);
        }
        while(stack.size()>1) stack.pop();
        return stack.peek();
    }

}
