package leetcode;

import java.util.Arrays;

public class CountPrimes204 {

    /**
     * 暴力解法，超时，使用isPrime2方法判断不会超时
     * @param n
     * @return
     */
    public int solution1(int n){
        int result=0;
        for(int i=2;i<n;i++) if(isPrime(i)) result++;
        return result;
    }

    public boolean isPrime(int n){
        for(int i=2;i<n;i++) if(n%i==0) return false;
        return true;
    }

    public boolean isPrime2(int n){
        for(int i=2;i*i<=n;i++) if(n%i==0) return false;
        return true;
    }


    /**
     * 遍历所有非质数
     * @param n
     * @return
     */
    public int solution2(int n){
        int result=0;
        boolean[] flag=new boolean[n];
        Arrays.fill(flag,true);
        for(int i=2;i*i<=n;i++){
            if(flag[i]) for(int j=i*i;j<n;j+=i) flag[j]=false;
        }
        for(int i=2;i<n;i++) if(flag[i]) result++;
        return result;
    }

}
