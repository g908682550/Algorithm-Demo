package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams438 {


    @Test
    public void test(){
        System.out.println(solution2("cbaebabacd","abc"));
    }

    /**
     * 基于map的滑动窗口
     * @param s
     * @param p
     * @return
     */
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
                if(windows.get(curr).equals(needs.get(curr))) match++;
            }
            j++;
            while(match==needs.size()){
                if(p.length()==j-i) result.add(i);
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

    /**
     * 借助两个大小为26的数组来实现滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> solution2(String s, String p){
        int[] needs=new int[26];
        int[] windows=new int[26];
        List<Integer> result=new ArrayList<>();
        int i=0,j=0,n=p.length(),match=0,flag=0;
        for(int k=0;k<n;k++) needs[p.charAt(k)-97]++;
        for(int k=0;k<26;k++) if(needs[k]>0) flag++;
        while(j<s.length()){
            char curr=s.charAt(j);
            if(needs[curr-97]>0) {
                windows[curr-97]++;
                if(windows[curr-97]==needs[curr-97]) match++;
            }
            j++;
            while(match==flag){
                if(j-i==p.length()) result.add(i);
                char pre=s.charAt(i);
                windows[pre-97]--;
                if(windows[pre-97]>=0&&windows[pre-97]<needs[pre-97]) match--;
                i++;
            }
        }
        return result;
    }
}
