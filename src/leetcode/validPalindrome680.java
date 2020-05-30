package leetcode;

public class validPalindrome680 {


    public boolean solution(String s){
        int right=s.length()-1,left=0;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return isTrue(s.substring(left,right))||isTrue(s.substring(left+1,right+1));
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isTrue(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }

}
