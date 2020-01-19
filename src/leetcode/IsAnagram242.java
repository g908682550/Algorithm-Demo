package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram242 {


    @Test
    public void test(){
        String s="anagram";
        String t="nagaram";
        System.out.println(solution2(s, t));
        char c=97;
        System.out.println(c);
    }

    /**
     * 根据两个字符串创建两个map，如果两个map完全相等，则返回true，否则返回false；
     * @param s
     * @param t
     * @return
     */
    public boolean solution1(String s, String t){
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(Character c:s.toCharArray()){
            if(map1.containsKey(c)) map1.put(c,map1.get(c)+1);
            else map1.put(c,1);
        }
        for(Character c:t.toCharArray()){
            if(map2.containsKey(c)) map2.put(c,map2.get(c)+1);
            else map2.put(c,1);
        }
        if(map1.size()!=map2.size()) return false;
        for(Map.Entry<Character,Integer> entry:map1.entrySet()){
            Character c=entry.getKey();
            Integer count=entry.getValue();
            if(!map2.containsKey(c)||!map2.get(c).equals(count)) return false;
        }
        return true;
    }

    /**
     * 开辟两个26大小的数组，如果数组完全相等则返回true，否则返回false
     * @param s
     * @param t
     * @return
     */
    public boolean solution2(String s,String t){
        int[] nums1=new int[26];
        int[] nums2=new int[26];
        for(char c:s.toCharArray()) nums1[c-97]++;
        for(char c:t.toCharArray()) nums2[c-97]++;
        return Arrays.equals(nums1,nums2);
    }

}
