package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {

    List<String> result=new ArrayList<>();

    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    /**
     * 递归调用方法
     * @param digits
     * @return
     */
    public List<String> solution1(String digits){
        if(digits.length()==0) return result;
        helper(digits,0,"");
        return result;
    }

    public void helper(String digits,int index,String curr){
        if(index==digits.length()) {//如果索引长度和字符串长度相同，则将其加入结果集并返回
            result.add(curr);
            return;
        }
        char c=digits.charAt(index);
        String temp=map[c-'0'];
        for(int i=0;i<temp.length();i++) helper(digits,index+1,curr+temp.charAt(i));//传入索引以及当前的字符串
    }

    /**
     * 迭代方法
     * @param digits
     * @return
     */
    public List<String> solution2(String digits){
        List<String> result=new ArrayList<>();
        int n=digits.length();
        if(n==0) return result;
        for(int i=0;i<n;i++){//总共需遍历这些次数
            char c=digits.charAt(i);
            String curr=map[c-'0'];
            result=helper(result,curr);//获取到下一次要迭代的结果集
        }
        return result;
    }
    public List<String> helper(List<String> list,String curr){
        List<String> result=new ArrayList();
        int n=list.size();
        if(n==0) for(int j=0;j<curr.length();j++) result.add(curr.charAt(j)+"");//对于第一个数字要进行单独遍历
        for(int i=0;i<n;i++){
            String s=list.get(i);
            for(int j=0;j<curr.length();j++) result.add(s+curr.charAt(j));

        }
        return result;
    }

}
