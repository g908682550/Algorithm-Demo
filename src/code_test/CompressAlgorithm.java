package code_test;
import java.util.*;
public class CompressAlgorithm {

    static StringBuilder result=new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int len=s.length();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c!='[') result.append(c);
            else i=helper(s,i);
        }
        System.out.println(result.toString());
    }

    public static int helper(String s,int i){
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(i));
        int sum=1;
        i++;
        while(sum>0){
            char c=s.charAt(i);
            if(c!=']') {
                if(c=='[') sum++;
                stack.push(c);
            }
            else{
                StringBuilder inner=new StringBuilder();
                while(stack.peek()!='['){
                    inner.insert(0,stack.pop());
                }
                stack.pop();
                int index=inner.indexOf("|");
                Integer num=Integer.parseInt(inner.substring(0,index));
                String sub=inner.substring(index+1,inner.length());
                StringBuilder subTotal=new StringBuilder();
                for(int k=0;k<num;k++)  subTotal.append(sub);
                for(char curr:subTotal.toString().toCharArray()) stack.push(curr);
                sum--;
            }
            i++;
        }
        int num=result.length();
        while(!stack.isEmpty()) result.insert(num,stack.pop());
        return i-1;
    }

}
