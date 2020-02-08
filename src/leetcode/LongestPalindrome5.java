package leetcode;

public class LongestPalindrome5 {

    /**
     * dp[i][j]表示字符串下标i到j字符串是否为回文串
     * @param s
     * @return
     */
    public String solution1(String s){
        int num=s.length();
        if(num<=1) return s;
        String res="";
        boolean[][] dp=new boolean[num][num];
        for(int j=1;j<num;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                    if(dp[i][j]&&j-i+1>res.length()) res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    String s;
    int num;

    /**
     * 从中向外扩散
     * @param s
     * @return
     */
    public String solution2(String s){
        this.s=s;
        num=s.length();
        String res="";
        if(num<=1) return s;
        for(int i=0;i<num;i++){
            int curr=Math.max(count(i,i),count(i,i+1));
            if(curr>res.length()){
                res=s.substring(i-(curr-1)/2,i+1+curr/2);
            }
        }
        return res;
    }

    public int count(int i,int j){
        while(i>=0&&j<num){
            if(s.charAt(i)!=s.charAt(j)) return j-i-1;
            else{
                i--;
                j++;
            }
        }
        return j-i-1;
    }

}
