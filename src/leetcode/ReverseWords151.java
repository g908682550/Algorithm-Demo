package leetcode;
import org.junit.Test;

import java.util.*;
public class ReverseWords151 {

    @Test
    public void test(){
        String s=" hello world! ";
        System.out.println(solution(s));
    }

    public String solution(String s){
        int index=0,n=s.length();
        if(n==0) return "";
        List<String> list=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        while(index<n){
            temp.delete(0,temp.length());
            while(index<n&&s.charAt(index)==' ') index++;
            while(index<n&&s.charAt(index)!=' '){
                temp.append(s.charAt(index));
                index++;
            }
            list.add(temp.toString());
        }
        Collections.reverse(list);
        temp.delete(0,temp.length());
        for(int i=0;i<list.size()-1;i++) temp.append(list.get(i)+" ");
        temp.append(list.get(list.size()-1));
        return temp.toString();
    }

}
