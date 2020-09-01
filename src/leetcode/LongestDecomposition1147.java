package leetcode;

import org.junit.Test;

public class LongestDecomposition1147 {

    @Test
    public void test(){
        String text="ghiabcdefhelloadamhelloabcdefghi";
        longestDecomposition(text);
    }

    public int longestDecomposition(String text) {
        int result=0;
        int i=0,j=text.length();
        while(i<j){
            int num=1;
            while(!text.substring(i,i+num).equals(text.substring(j-num,j))){
                num++;
            }
            if(i+num==j) result+=1;
            result+=2;
            i+=num;
            j-=num;
        }
        return result;
    }


}
