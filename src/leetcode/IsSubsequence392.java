package leetcode;

public class IsSubsequence392 {


    public boolean solution(String s, String t){
        int i=0,j=0;
        int len1=s.length(),len2=t.length();
        if(len2==0) return len1==0?true:false;
        while(i<len1&&j<len2){
            char curr=s.charAt(i);
            if(curr==t.charAt(j)) i++;
            j++;
        }
        return i==len1?true:false;
    }

}
