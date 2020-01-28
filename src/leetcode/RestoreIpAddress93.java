package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress93 {

    @Test
    public void test(){
        String s="25525511135";
        System.out.println(Integer.parseInt("010"));
        solution1(s);
    }

    /**
     * 暴力解法
     * @param s
     * @return
     */
    public List<String> solution1(String s){
        List<String> result=new ArrayList<>();
        for(int a=1;a<4;a++)
            for(int b=1;b<4;b++)
                for(int c=1;c<4;c++)
                    for(int d=1;d<4;d++){
                        if(a+b+c+d==s.length()){//可以剪的长度和s相等时进行判断
                            Integer n1=Integer.parseInt(s.substring(0,a));
                            Integer n2=Integer.parseInt(s.substring(a,a+b));
                            Integer n3=Integer.parseInt(s.substring(a+b,a+b+c));
                            Integer n4=Integer.parseInt(s.substring(a+b+c,a+b+c+d));
                            if(n1<=255&&n2<=255&&n3<=255&&n4<=255) {
                                String curr=new String(n1+"."+n2+"."+n3+"."+n4);
                                if(curr.length()==s.length()+3) result.add(curr);//这里判断是对以0为开头的字符串转化的整数进行防范
                            }
                        }
                    }
        return result;
    }

    List<String> result=new ArrayList<>();

    /**
     * 回溯法
     * @param s
     * @return
     */
    public List<String> solution2(String s){
        helper(0,4,s,"");
        return result;
    }

    /**
     *
     * @param i 表示当前所在的字符串位置
     * @param re  表示剩余的ip组数（一共4个）
     * @param s   原始字符串
     * @param temp 当前拼接的字符串
     */
    public void helper(int i,int re,String s,String temp){
        if(i==s.length()&&re==0) {
            result.add(temp.substring(0,temp.length()-1));
            return;
        }
        if(re<0) return;
        for(int j=i;j<i+3;j++){
            if(j<s.length()){
                if(i==j&&s.charAt(j)=='0'){
                    helper(j+1,re-1,s,temp+"0.");
                    break;
                }
                if(Integer.parseInt(s.substring(i,j+1))<=255)
                    helper(j+1,re-1,s,temp+s.substring(i,j+1)+".");

            }
        }
    }


}
