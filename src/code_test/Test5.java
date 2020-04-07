package code_test;

import java.util.*;

public class Test5 {
    public static void main(String[] args){
        System.out.println(test());
    }

    public static int test(){
        int i=0;
        try{
            i++;
            return i;
        }catch (Exception e){
            i++;
        }finally {
            i++;
        }
        return 1;
    }
}
