package code_test;

import java.util.Scanner;

public class MeiTuan1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        scanner.nextLine();
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        int[][] nums=new int[2][num];
        int[][] dp=new int[2][num];
        for(int i=0;i<num;i++) if(s1.charAt(i)=='X') nums[0][i]=1;
        for(int i=0;i<num;i++) if(s2.charAt(i)=='X') nums[1][i]=1;
        if(nums[0][0]==1||nums[1][num-1]==1) System.out.println(-1);
        dp[0][0]=1;
        if(nums[1][0]==0) dp[1][0]=1;
        int j=1;
        while(j<num){
            if(nums[0][j]==0) dp[0][j]=dp[1][j-1]+dp[0][j-1];
            if(nums[1][j]==0) dp[1][j]=dp[0][j-1]+dp[1][j-1];
            j++;
        }
        System.out.println(dp[1][num-1]);
    }

}
