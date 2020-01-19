package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IsHappy202 {


    @Test
    public void test(){
        System.out.println(solution1(19));
    }

    Set<Integer> set=new HashSet<>();

    /**
     * 借助于set集合判断
     * @param n
     * @return
     */
    public boolean solution1(int n){
        while(n!=1){
            if(set.contains(n)) return false;
            set.add(n);
            n=helper(n);
        }
        return true;
    }

    /**
     * 借助于快慢指针判断
     * @param n
     * @return
     */
    public boolean solution2(int n){
        int slow=n,fast=n;
        do{
            slow=helper(slow);
            fast=helper(fast);
            fast=helper(fast);
        }while(slow!=fast);
        return slow==1;
    }

    public int helper(int n){
        int result=0;
        String s=String.valueOf(n);
        for(char c:s.toCharArray()){
            int temp=Integer.parseInt(c+"");
            result+=temp*temp;
        }
        return result;
    }
}
