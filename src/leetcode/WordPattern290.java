package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern290 {

    @Test
    public void test(){
        String pattern="abba";
        String str="dog cat cat dog";
        System.out.println(solution1(pattern, str));
    }


    public boolean solution1(String pattern, String str){
        String[] strs=str.split(" ");
        Map<Character,String> map=new HashMap<>();
        if(pattern.length()!=strs.length) return false;
        for(int i=0;i<pattern.length();i++){
            Character c=pattern.charAt(i);
            String curr=strs[i];
            if(map.containsKey(c)&&!map.get(c).equals(curr)) return false;
            else {
                map.put(c,curr);
            }
        }
        //这里需要判断不同字符指向相同单词的情况
        Set<String> set=new HashSet<>();
        for(Map.Entry<Character,String> entry:map.entrySet()){
            if(set.contains(entry.getValue())) return false;
            set.add(entry.getValue());
        }
        return true;
    }

}
