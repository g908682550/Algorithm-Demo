package leetcode;

import org.junit.Test;

public class IsPalindrome125 {

    @Test
    public void test(){
        String s="A man, a plan, a canal: Panama";
        System.out.println(solution1(s));
    }

    public boolean solution1(String s){
        char[] chars=s.toCharArray();
        int left=0,right=chars.length-1;
        while(left<=right){
            char a=chars[left],b=chars[right];
            if(Character.isLetterOrDigit(a)&&Character.isLetterOrDigit(b)){
                if(Character.toLowerCase(a)!=Character.toLowerCase(b)) return false;
                else{
                    left++;
                    right--;
                }
            }
            else{
                if(!Character.isLetterOrDigit(a)) left++;
                if(!Character.isLetterOrDigit(b)) right--;
            }
        }
        return true;
    }
}
