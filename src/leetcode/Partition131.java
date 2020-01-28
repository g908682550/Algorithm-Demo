package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {

    @Test
    public void test(){
        String s="aab";
        System.out.println(s.substring(2,3));
    }


    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solution(String s){
            List<String> list=new ArrayList<>();
            helper(list,s);
            return result;

    }

    public void helper(List<String> list,String temp){
        if(temp.length()==0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<temp.length();i++){
            String curr=temp.substring(0,i+1);
            String re=temp.substring(i+1,temp.length());
            if(isPali(curr)){//如果当前元素为回文串，进行递归调用，否则进行下一次循环
                list.add(curr);
                helper(list,re);
                list.remove(list.size()-1);//删除最后一个元素而不要直接删除curr
            }
        }
    }

    //判断是否为回文串
    public boolean isPali(String s){
        if(s.length()==0) return false;
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

}
