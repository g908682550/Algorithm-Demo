package leetcode;

import org.junit.Test;

import java.util.*;

public class FindTheLongestSubstring1371 {

    @Test
    public void test(){
        String s="eleetminicoworoep";
        solution(s);
        switch (s){
            case "":
        }
    }

    public int solution(String s){
        int n=s.length(),result=0;
        boolean flag=true;
        Set<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int j=i;
            map.clear();
            while(j<n){
                char c=s.charAt(j++);
                if(set.contains(c)){
                    map.put(c,map.getOrDefault(c,0)+1);
                    if(isTrue(map)) flag=true;
                    else flag=false;
                }
                if(flag) result=Math.max(j-i+1,result);
            }
        }
        return result;
    }

    public boolean isTrue(Map<Character,Integer> map){
        for(int num:map.values()) if(num%2==1) return false;
        return true;
    }


}
