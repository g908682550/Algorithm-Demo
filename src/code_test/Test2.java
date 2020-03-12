package code_test;

import java.util.List;
import java.util.Scanner;

public class Test2 {

    static long sum=0,n,k,L,R;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        L=scanner.nextInt();
        R=scanner.nextInt();
        helper(0,0);
        System.out.println(sum%1000000007);
    }

    public static void helper(int total,int index){
        if(index==n){
            if(total%k==0) sum++;
            return;
        }
        for(long i=L;i<=R;i++){
            helper(total+=i,index+1);
        }
    }
}
