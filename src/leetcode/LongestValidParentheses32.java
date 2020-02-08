package leetcode;

public class LongestValidParentheses32 {

    //从头开始遍历子串，依次求出子串的最长有效括号
    public int solution(String s){
        int res=0,num=s.length();
        for(int i=0;i<num;i++){
            res=Math.max(res,helper(s.substring(i,s.length())));
        }
        return res;
    }

    public int helper(String s){
        int len=s.length(),res=0,sum=0;
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(s.charAt(i)=='('){
                sum++;
            }else{
                if(sum==0) return res;
                else if(--sum==0) res=i+1;
            }
        }
        return res;
    }

}
