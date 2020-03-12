package code_test;
import java.util.*;
public class BooleanCount {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] ss=scanner.nextLine().split(" ");
        Stack<String> stack=new Stack<>();
        for(int i=0;i<ss.length;i++){
            String curr=ss[i];
            //当前值为true或false时
            if(curr.equals("true")||curr.equals("false")){
                if(stack.isEmpty()){
                    stack.push(curr);
                }else{
                    String top=stack.peek();
                    if(top.equals("true")||top.equals("false")){
                        System.out.println("error");
                        return;
                    }else{
                        if(top.equals("or")) stack.push(curr);
                        else{
                            stack.pop();
                            String pre=stack.pop();
                            if(curr.equals("false")||pre.equals("false")) stack.push("false");
                            else stack.push("true");
                        }
                    }
                }
            }
            //当前值为and或or时
            else{
                if(stack.isEmpty()){
                    System.out.println("error");
                    return;
                }else{
                    String top=stack.peek();
                    if(top.equals("and")||top.equals("or")){
                        System.out.println("error");
                        return;
                    }
                    stack.push(curr);
                }
            }
        }
        if(!stack.isEmpty()&&(stack.peek().equals("or")||stack.peek().equals("and"))){
            System.out.println("error");
            return;
        }
        while(!stack.isEmpty()){
            String curr=stack.pop();
            if(curr.equals("true")){
                System.out.println("true");
                break;
            }
            if(stack.isEmpty()) System.out.println("false");
        }
    }
}
