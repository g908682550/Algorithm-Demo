package leetcode;

import org.junit.Test;

public class CountDigitOne233 {

    @Test
    public void test(){
        System.out.println(solution(10012312));
    }

    public int solution(int n){
        if(n<=0) return 0;
        String s=String.valueOf(n);
        int high=s.charAt(0)-48;
        int pow=(int)Math.pow(10,s.length()-1);
        int last=n-high*pow;
        if(high==1) return solution(pow-1)+last+1+solution(last);
        else return high*solution(pow-1)+solution(last)+pow;
    }

}
