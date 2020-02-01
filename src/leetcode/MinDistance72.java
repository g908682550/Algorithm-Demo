package leetcode;

public class MinDistance72 {

    public void test(){

    }


    public int solution(String word1,String word2){
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++) dp[i][0]=i;
        for(int i=1;i<=len2;i++) dp[0][i]=i;
        for(int i=1;i<=len1;i++){
            char c1=word1.charAt(i-1);
            for(int j=1;j<=len2;j++){
                char c2=word2.charAt(j-1);
                if(c1==c2) dp[i][j]=dp[i-1][j-1];
                //添加、删除、替换
                else dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
            }
        }
        return dp[len1][len2];
    }

}
