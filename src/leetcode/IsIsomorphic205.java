package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic205 {

    @Test
    public void test(){
        String s="egg";
        String t="add";
        System.out.println(solution1(s, t));
    }

    public boolean solution1(String s, String t){
        Map<Character,Character> map=new HashMap<>();
        char[] chars1=s.toCharArray();
        char[] chars2=t.toCharArray();
        int n=chars1.length,m=chars2.length;
        if(n!=m) return false;
        for(int i=0;i<n;i++){
            char c=chars1[i];
            char p=chars2[i];
            if(map.containsKey(c)){
                if(map.get(c)!=p) return false;
            }else{
                if(map.containsValue(p)) return false;
                map.put(c,p);
            }
        }
        return true;
    }
}
