package code_test;

import java.util.*;
public class Main5{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] nums=new long[n];
        for(int i=0;i<n;i++) nums[i]=scanner.nextInt();
        long[] temp=new long[n-1];
        long result=0;
        for(int i=0;i<n-1;i++) {
            temp[i]=nums[i+1]-nums[i];
            if(temp[i]==0){
                System.out.println(-1);
                return;
            }
            result=gcd(result,temp[i]);
        }
        System.out.println(result);
    }

    public static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
