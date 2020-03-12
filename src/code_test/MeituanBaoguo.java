package code_test;
import java.util.*;
public class MeituanBaoguo {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int i=0,j=0,len=s.length();
        while(j<len){
            char c=s.charAt(j);
            int tail=s.lastIndexOf(c);
            int pre=j;
            i=j+1;
            j=tail;
            while(i<j){
                char inner=s.charAt(i);
                j=Math.max(j,s.lastIndexOf(inner));
                i++;
            }
            j++;
            System.out.print(j-pre+" ");
        }
    }

}
