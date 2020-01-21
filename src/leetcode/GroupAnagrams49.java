package leetcode;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams49 {


    @Test
    public void test(){
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution1(strs));
    }

    public List<List<String>> solution1(String[] strs){
        int n=strs.length;
        Map<String, List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=strs[i];
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(key,list);
            }
        }
        return new ArrayList(map.values());
    }

}
