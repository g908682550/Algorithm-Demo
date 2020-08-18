package test;

import org.junit.Test;


import java.util.regex.Pattern;


public class Test1 {

    Pattern compile = Pattern.compile("([A-Z]+_?)*[A-Z]$");
    String s="";

    @Test
    public void test() {
        StringBuilder builder=new StringBuilder();
        builder.insert(0,'a');
        builder.insert(0,'b');
        System.out.println(builder.toString());
        Integer c='0'-48;
        System.out.println(c);
        char a=48;
        System.out.println(a);
        int q=0;
    }

    public String convertToUpper(String source){
        StringBuilder dest=new StringBuilder();
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!='_'){
                dest.append(source.charAt(i));
            }else{
                i++;
                if(i==source.length()){
                    break;
                }
                dest.append(Character.toUpperCase(source.charAt(i)));
            }
        }
        return dest.toString();
    }
}
