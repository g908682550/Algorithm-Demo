package code_test;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        int a=new Integer(100);
        int b=new Integer(100);
        Integer c=new Integer(150);
        Integer d=new Integer(150);
        System.out.println(a==b);
        System.out.println(c==150);
        System.out.println(c==d);
    }

    public static void test(String p,String t){
        int n=p.length(),m=t.length();
        int temp=0;
        char[] chars1=p.toCharArray();
        char[] chars2=t.toCharArray();
        for(int i=0;i<n;i++){
            int j=i;
            while(j<n&&temp<m&&chars1[j]==chars2[temp]){
                temp++;
                j++;
            }
            if(temp==m){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("No");
    }
}
