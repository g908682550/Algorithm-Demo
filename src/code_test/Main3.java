package code_test;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int i=0;i<T;i++){
            int max=0,index=0;
            int n=scanner.nextInt();
            int[] nums=new int[n];
            int[] rank=new int[n];
            for(int j=0;j<n;j++) nums[j]=scanner.nextInt();
            for(int j=0;j<n;j++) {
                rank[j]=scanner.nextInt();
                if(rank[j]>max){
                    max=rank[j];
                    index=j;
                }
            }
            int res=0;
            if(n==1){
                System.out.println(rank[0]);
                return;
            }
            if(n%2==0){
                for(int num:rank) res+=num;
            }else{
                int num1,num2;
                if(index==0){
                    if(rank[index+1]<rank[index+2]){
                        num1=index+1;
                        num2=index+2;
                    }else{
                        num1=index+2;
                        num2=index+1;
                    }
                }else if(index==n-1){
                    if(rank[index-1]<rank[index-2]){
                        num1=index-1;
                        num2=index-2;
                    }else{
                        num1=index-2;
                        num2=index-1;
                    }
                }
                else if(index%2==0){
                    int pre1=rank[index-1],pre2=rank[index-2];
                    int pre=0,post=0;
                    if(pre1>pre2){
                        pre=pre2*2+pre1;
                    }else{
                        pre=pre1*2+pre1;
                    }
                    int post1=rank[index+1],post2=rank[index+2];
                    if(post1>post2){
                        post=post2*2+post1;
                    }else{
                        post=post1*2+post2;
                    }
                    if(pre>post){
                        if(rank[index+1]>rank[index+2]){
                            num1=index+2;
                            num2=index+1;
                        }else{
                            num1=index+1;
                            num2=index+2;
                        }
                    }else{
                        if(rank[index-1]<rank[index-2]){
                            num1=index-1;
                            num2=index-2;
                        }else{
                            num1=index-2;
                            num2=index-1;
                        }
                    }
                }else{
                    if(rank[index-1]>rank[index+1]){
                        num1=index+1;
                        num2=index-1;
                    }else{
                        num1=index-1;
                        num2=index+1;
                    }
                }
                for(int k=0;k<n;k++){
                    if(k==num1) res+=rank[k]*2;
                    else res+=rank[k];
                }
            }
            System.out.println(res);
        }
    }
}
