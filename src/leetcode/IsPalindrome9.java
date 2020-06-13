package leetcode;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class IsPalindrome9 {

    @Test
    public void test(){
        System.out.println(solution(121));
        Map<String,Integer> map=new TreeMap<>();
        String s="a";
        String ss="b";
        System.out.println(s.compareTo(ss));
    }

    //转成字符串进行比较
    public boolean solution(int x){
        String s=String.valueOf(x);
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


}
