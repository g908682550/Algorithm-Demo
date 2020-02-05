package offer;

import org.junit.Test;

public class ReverseSentence {

    @Test
    public void test(){
        String str="I am a student.";
        solution(str);
    }

    public String solution(String str){
        if(str.length()==0||str.trim().equals("")) return str;
        String[] strs=str.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            if(i==0) result.append(strs[i]);
            else{
                result.append(strs[i]);
                result.append(" ");
            }
        }
        return result.toString();
    }


}
