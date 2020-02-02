package leetcode;

import java.util.*;

public class WordBreak139 {

    Map<String,Boolean> map=new HashMap<>();

    /**
     * 记忆化搜索，存在大量重复计算，提交会超时
     * @return
     */
    public boolean solution1(String s, List<String> wordDict){
        if(s.length()==0||wordDict.contains(s)) return true;
        int n=s.length();
        for(int i=0;i<n;i++){
            String curr=s.substring(0,i+1);
            boolean sub=false;
            if(wordDict.contains(curr)){
                sub=solution1(s.substring(i+1,s.length()),wordDict);
            }
            if(!sub) continue;
            else return true;
        }
        return false;
    }

    /**
     * 通过保存重复元素到map，不用重复计算
     * @param s
     * @param wordDict
     * @return
     */
    public boolean solution2(String s, List<String> wordDict){
        if(map.containsKey(s)) return map.get(s);
        if(s.length()==0||wordDict.contains(s)){
            map.put(s,true);
            return true;
        }
        int n=s.length();
        for(int i=0;i<n;i++){
            String curr=s.substring(0,i+1);
            boolean sub=false;
            if(wordDict.contains(curr)){
                sub=solution2(s.substring(i+1,s.length()),wordDict);
                map.put(s.substring(i+1,s.length()),sub);
            }
            if(!sub) continue;
            else return true;
        }
        return false;
    }

    /**
     * 动态规划求解，dp[i]表示以当前索引结尾是否能匹配
     * @param s
     * @param wordDict
     * @return
     */
    public boolean solution3(String s,List<String> wordDict){
        int n=s.length();
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
