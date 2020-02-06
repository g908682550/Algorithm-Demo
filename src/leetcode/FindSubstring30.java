package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring30 {

    @Test
    public void test(){

        String s="aaaaaaaa";
        String[] words={"aa","aa","aa"};
        solution(s,words);
    }

    /**
     * 滑动窗口机制，时间复杂度(0(words.length*s.length())
     * @param s
     * @param words
     * @return
     */
    public List<Integer> solution(String s, String[] words){
        List<Integer> result=new ArrayList<>();
        if(s.length()==0||words.length==0) return result;
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer> window=new HashMap<>();
        for(String word:words) map.put(word,map.getOrDefault(word,0)+1);
        int len=words[0].length();
        for(int i=0;i<len;i++){
            int start=i,end=i+len,count=0;
            window.clear();
            while(end<=s.length()){
                String curr=s.substring(end-len,end);
                if(map.containsKey(curr)){
                    window.put(curr,window.getOrDefault(curr,0)+1);
                    count++;
                    while(window.get(curr)>map.get(curr)){
                        String other=s.substring(start,start+len);
                        window.put(other,window.get(other)-1);
                        start+=len;
                        count--;
                    }
                    if(count==words.length) result.add(start);
                }else{
                    window.clear();
                    start=end;
                    count=0;
                }
                end+=len;
            }
        }
        return result;
    }

}
