package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddBinary67 {

    public void test(){

    }

    public String solution(String a,String b){
        StringBuilder result=new StringBuilder();
        List<Character> sa=new ArrayList<>();
        List<Character> sb=new ArrayList<>();
        for(char c:a.toCharArray()) sa.add(c);
        for(char c:b.toCharArray()) sb.add(c);
        if(sa.size()<sb.size()){
            int num=sb.size()-sa.size();
            while(num-->0) sa.add(0,'0');
        }else if(sa.size()>sb.size()){
            int num=sa.size()-sb.size();
            while(num-->0) sb.add(0,'0');
        }
        int flag=0;
        for(int i=sa.size()-1;i>=0;i--){
            char char_a=sa.get(i),char_b=sb.get(i);
            int num=char_a+char_b-96+flag;
            if(num>=2){
                num=num%2;
                flag=1;
            }else flag=0;
            char c=(char)(num+48);
            result.insert(0,c);
        }
        if(flag==1) result.insert(0,'1');
        return result.toString();
    }

}
