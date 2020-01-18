package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring3 {

    @Test
    public void test(){
        String s="abcabcbb";
        System.out.println(solution2(s));
    }


    /**
     * 对字符串进行两次遍历得到
     * @param s
     * @return
     */
    public int solution1(String s){
        int n=s.length(),result=0;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.clear();
            for(int j=i;j<n;j++){
                Character c=s.charAt(j);
                if(set.contains(c)) break;
                else set.add(c);
            }
            result=Math.max(result,set.size());
        }
        return result;
    }

    /**
     * 基于set的滑动窗口，i一步步移动直至删除重复元素
     */
    public int solution2(String s){
        int n=s.length(),result=0;
        Set<Character> set=new HashSet<>();
        int i=0,j=0;
        while(j<n){
            Character c=s.charAt(j);
            while(set.contains(c)&&i<j) set.remove(s.charAt(i++));
            set.add(c);
            result=Math.max(j-i+1,result);
            j++;
        }
        return result;
    }

    /**
     * 借助于map的滑动窗口，当有重复元素时直接将i移动到指定位置
     * @param s
     * @return
     */
    public int solution3(String s){
        int n=s.length(),result=0;
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        while(j<n){
            Character c=s.charAt(j);
            if(map.containsKey(c)) i=Math.max(i,map.get(c)+1);
            map.put(c,j++);
            result=Math.max(result,j-i);
        }
        return result;
    }

    /**
     * 借助于255个数组大小长度的滑动窗口
     * @param s
     * @return
     */
    public int solution4(String s){
        int n=s.length(),result=0;
        int[] chars=new int[255];
        int i=0,j=0;
        while(j<n){
            chars[s.charAt(j++)]++;
            while(chars[s.charAt(j-1)]>1) chars[s.charAt(i++)]--;
            result=Math.max(result,j-i);
        }
        return result;
    }

}
