package offer;

import org.junit.Test;

public class ReverseWords58 {

    @Test
    public void test(){
        String s="a good   example";
        solution(s);
    }


    public String solution(String s){
        s=s.trim();
        String[] ss=s.split(" ");
        int n=ss.length-1;
        for(int i=0;i<=n;i++) ss[i]=ss[i].trim();
        for(int i=0;i<=n/2;i++){
            String temp=ss[i];
            ss[i]=ss[n-i];
            ss[n-i]=temp;
        }
        String result="";
        for(int i=0;i<n;i++) result+=ss[i]+" ";
        result+=ss[n];
        return result;
    }

}
