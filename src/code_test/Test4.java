package code_test;

import java.util.*;

public class Test4 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] ss=s.split(",");
        for(int i=1;i<ss.length;i++){
            String insertValue=ss[i];
            int insertIndex=i-1;
            while(insertIndex>=0&&canInsert(insertValue,ss[insertIndex]))
                ss[insertIndex+1]=ss[insertIndex--];
            ss[insertIndex+1]=insertValue;
        }
        for(int i=0;i<ss.length-1;i++) System.out.print(ss[i]+",");
        System.out.print(ss[ss.length-1]);
    }

    public static boolean canInsert(String s1,String s2){
        if(s2.startsWith(s1)||s1.equals(" ")) return true;
        if(s1.startsWith(s2)) return false;
        return s1.compareTo(s2)>0;
    }
}
