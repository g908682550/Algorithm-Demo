package code_test;

import java.util.*;

public class Test {

    static int[][] dir={{0,1},{1,1},{-1,1}};
    static int[][] path,nums;
    static int num;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        num=scanner.nextInt();
        scanner.nextLine();
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        path=new int[2][num];
        nums=new int[2][num];
        for(int i=0;i<num;i++) if(s1.charAt(i)=='X') nums[0][i]=1;
        for(int i=0;i<num;i++) if(s2.charAt(i)=='X') nums[1][i]=1;
        if(nums[0][0]==1||nums[1][num-1]==1) System.out.println(-1);
        helper(0,0);
        if(path[1][num-1]>0) System.out.println(path[1][num-1]);
        else System.out.println(-1);
    }

    public static void helper(int x,int y){
        path[x][y]++;
        if(x==1&&y==num-1) return;
        for(int k=0;k<3;k++){
            int nextX=x+dir[k][0],nextY=y+dir[k][1];
            if(isTrue(nextX,nextY)&&nums[nextX][nextY]==0) helper(nextX,nextY);
        }
    }

    public static boolean isTrue(int x,int y){
        return x>=0&&x<2&&y>=0&&y<num;
    }
}

