package leetcode;

public class NumDecodings91 {

    /**
     * 从后往前动态规划求解
     * @param s
     * @return
     */
    public int solution(String s){
        int n=s.length();
        int[] dp=new int[n];
        //对最后的元素赋一个初始值
        if(s.charAt(n-1)=='0') dp[n-1]=0;
        else dp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            char curr=s.charAt(i);
            //以"0"为起始的解码方式都为0
            if(curr=='0') dp[i]=0;
            else{
                //获得当前元素与下一个元素组成的数字
                Integer num=Integer.parseInt(s.substring(i,i+2));
                if(num<=26){
                    //这里是对倒数第二个元素单独做判断，防止数组越界
                    if(i==n-2) dp[i]=dp[i+1]+1;
                    //若当前数字小于等于26，以该位置为起始位置的最大解码方式为dp[i+1]（单独作为一个数字解码）+dp[i+2]（与后面的数字组合作为一个数字解码）
                    else dp[i]=dp[i+1]+dp[i+2];
                }else{
                    //当前数字大于26，只能单独作为一个数字进行解码
                    dp[i]=dp[i+1];
                }
            }
        }
        return dp[0];
    }
}
