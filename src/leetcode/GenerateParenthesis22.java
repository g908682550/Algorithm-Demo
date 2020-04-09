package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {

    List<String> result=new ArrayList<>();

    public List<String> solution(int n){
        if(n==0) return result;
        helper("",n,n);
        return result;
    }

    public void helper(String s,int left,int right){
        if(left==0&&right==0){
            result.add(s);
            return;
        }
        if(left>right) return;
        if(left>0) helper(s+"(",left-1,right);
        if(left<right&&right>0) helper(s+")",left,right-1);
    }

}
