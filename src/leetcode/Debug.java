package leetcode;

import org.junit.Test;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Debug {

    @Test
    public void test(){
        int m=3;
        int n=2;
        System.out.println((double)m/n);
    }

    public List<Integer> solution1(String s, String p){
        List<Integer> result=new ArrayList<>();
        int i=0,j=0,match=0,n=s.length();
        char[] chars=p.toCharArray();
        Map<Character,Integer> needs=new HashMap<>();
        Map<Character,Integer> windows=new HashMap<>();
        for(Character c:chars){
            if(needs.containsKey(c)) needs.put(c,needs.get(c)+1);
            else needs.put(c,1);
        }
        while(j<n){
            Character curr=s.charAt(j);
            if(needs.containsKey(curr)){
                if(windows.containsKey(curr)) windows.put(curr,windows.get(curr)+1);
                else windows.put(curr,1);
                if(windows.get(curr)==needs.get(curr)) match++;
            }
            j++;
            while(match==needs.size()){
                if(windows.size()==j-i+1) result.add(i);
                Character pre=s.charAt(i);
                if(windows.containsKey(pre)) {
                    windows.put(pre,windows.get(pre)-1);
                    if(windows.get(pre)<needs.get(pre)) match--;
                }
                i++;
            }
        }
        return result;
    }


}
