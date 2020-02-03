package leetcode;

import java.util.Arrays;

public class FindContentChildren455 {

    /**
     * 先将最大的饼干满足胃口最大的
     * @param g
     * @param s
     * @return
     */
    public int solution(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        int i=s.length-1,j=g.length-1;
        while(i>=0&&j>=0){
            if(s[i]>=g[j]){
                result++;
                i--;
                j--;
            }else{
                j--;
            }
        }
        return result;
    }

}
