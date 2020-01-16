package leetcode;

import org.junit.Test;

public class ReverseString344 {


    @Test
    public void test(){
        String s1="hello";
        char[] s=s1.toCharArray();
        solution1(s);
        System.out.println(s);
    }

    /**
     * 双指针交换
     * @param s
     */
    public void solution1(char[] s){
        int left=0,right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
