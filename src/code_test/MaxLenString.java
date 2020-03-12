package code_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，每次机会可以将串中的某个0改成1，现在问最大的可能答案
 */
public class MaxLenString {

    static int len;
    static int k;
    static String s;

    /**
     * 滑动窗口
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        len=scanner.nextInt();
        k=scanner.nextInt();
        int[] temp=new int[len];
        for(int i=0;i<len;i++) temp[i]=scanner.nextInt();
        int i=0,j=0,res=0;
        while(j<len){
            if(temp[j]==0)
                k--;
            j++;
            while(i<len&&k==-1){
                if(temp[i]==0) k++;
                i++;
            }
            res=Math.max(res,j-i);
        }
        System.out.println(res);
    }

}
