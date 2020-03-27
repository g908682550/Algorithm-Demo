package leetcode;

import java.util.Arrays;

public class HasGroupsSizeX914 {


    public boolean solution(int[] deck) {
        Arrays.sort(deck);
        int n=deck.length;
        if(n<=1) return false;
        int pre=deck[0],count=1;
        //count为第一个数出现的次数
        for(int i=1;i<n;i++)
            if(deck[i]==pre) count++;
            else break;
        if(count==n) return true;
        //分别以2、3、4...count为计数对数组进行判断
        for(int k=2;k<=count;k++){
            if(n%k!=0) continue;
            int pre0=deck[k],flag=0;
            for(int i=k;i<n;i++){
                if(deck[i]==pre0) flag++;
                else if(flag<k) break;
                if(flag==k){
                    if(i==n-1) return true;
                    pre0=deck[i+1];
                    flag=0;
                }
            }
        }
        return false;
    }
}
