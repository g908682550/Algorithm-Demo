package leetcode;

import org.junit.Test;

public class findKthNumber440 {

    @Test
    public void test(){
        int n=13,k=5;
        solution(n,k);
    }

    int n;

    public int solution(int n,int k){
        this.n=n;
        int count=1,curr=1;
        while(true){
            if(count==k) return curr;
            int num=getCount(curr,curr+1);
            if(count+num<k){
                curr++;
                count+=num;
            }else{
                count++;
                curr*=10;
            }
        }
    }

    public int getCount(int start,int last){
        int result=0;
        while(start<n){
            result+=Math.min(n+1,last)-start;
            start*=10;
            last*=10;
        }
        return result;
    }

}
