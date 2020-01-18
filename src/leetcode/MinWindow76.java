package leetcode;

import org.junit.Test;

public class MinWindow76 {

    @Test
    public void test(){
        System.out.println(solution1("ADOBECODEBANC","ABC"));
    }

    /**
     * 基于两个255大小数组的滑动窗口实现
     * @param s
     * @param t
     * @return
     */
    public String solution1(String s, String t){
        int i=0,j=0,count=0,match=0;
        int[] needs=new int[255];
        int[] windows=new int[255];
        for(int k=0;k<t.length();k++) needs[t.charAt(k)]++;
        for(int k=0;k<255;k++) if(needs[k]>0) count++;
        String result=s+" ";
        while(j<s.length()){
            char curr=s.charAt(j);
            if(needs[curr]>0) {
                windows[curr]++;
                if(windows[curr]==needs[curr]) match++;
            }
            j++;
            while(match==count){
                result=j-i<result.length()?s.substring(i,j):result;
                char pre=s.charAt(i);
                if(needs[pre]>0){
                    windows[pre]--;
                    if(windows[pre]<needs[pre]) match--;
                }
                i++;
            }
        }
        return result.length()>s.length()?"":result;//如果不存在这样的子串，就返回"";
    }
}
