package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetPermutation60 {

    @Test
    public void test(){
        System.out.println(solution3(3, 3));
    }

    List<String> list=new ArrayList<>();
    int n,k;
    boolean[] flag;

    public String solution(int n, int k){
        this.n=n;
        this.k=k;
        flag=new boolean[n];
        list.add("");
        StringBuilder s=new StringBuilder();
        int m=1;
        while(m<=n){
            s.append(m+"");
            m++;
        }
        helper(s.toString(),new StringBuilder(),0);
        return list.get(k);
    }

    public void helper(String s,StringBuilder curr,int count){
        if(curr.length()==s.length()){
            list.add(s.toString());
            return;
        }
        for(int i=0;i<n;i++){
            if(!flag[i]){
                flag[i]=true;
                curr.append(s.charAt(i));
                helper(s,curr,count+1);
                curr.deleteCharAt(curr.length()-1);
                flag[i]=false;
            }
        }
        if(list.size()==k-1) return;
    }

    StringBuilder curr=new StringBuilder();
    int[] fac;

    /**
     * 递归搜索，提前剪枝
     * @param n
     * @param k
     * @return
     */
    public String solution2(int n,int k){
        this.n=n;
        this.k=k;
        flag=new boolean[n+1];
        fac=new int[n+1];
        fac[0]=1;
        for(int i=1;i<=n;i++) fac[i]=i*fac[i-1];
        dfs(0);
        return curr.toString();
    }

    public void dfs(int index){
        if(index==n) return;
        int c=fac[n-1-index];
        for(int i=1;i<=n;i++){
            if(flag[i]) continue;
            if(k>c){
                k-=c;
                continue;
            }
            flag[i]=true;
            curr.append(i+"");
            dfs(index+1);
        }
    }

    /**
     * 思路同上，借助于链表
     * @param n
     * @param k
     * @return
     */
    public String solution3(int n,int k){
        k--;
        fac=new int[n+1];
        fac[0]=1;
        for(int i=1;i<=n;i++) fac[i]=i*fac[i-1];
        List<Integer> list=new LinkedList<>();
        for(int i=1;i<=n;i++) list.add(i);

        for(int i=n-1;i>=0;i--){
            int index=k/fac[i];
            curr.append(list.remove(index));
            k-=index*fac[i];
        }
        return curr.toString();
    }



}
