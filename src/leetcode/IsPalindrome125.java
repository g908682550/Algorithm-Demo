package leetcode;

import org.junit.Test;

public class IsPalindrome125 {

    @Test
    public void test(){
        String s="A man, a plan, a canal: Panama";
        System.out.println(solution1(s));
    }

    public boolean solution1(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(right>left&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            char a=Character.toUpperCase(s.charAt(left++));
            char b=Character.toUpperCase(s.charAt(right--));
            if(a!=b) return false;
        }
        return true;
    }
}
