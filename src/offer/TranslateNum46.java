package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TranslateNum46 {


    @Test
    public void test(){
        System.out.println(solution(220));
    }

    /**
     * 动态规划
     * @param num
     * @return
     */
    public int solution(int num){
        List<Integer> list=count(num);
        int[] dp=new int[list.size()];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            int curr=list.get(i-1)*10+list.get(i);
            if(curr>9&&curr<=25){
                if(i>1) dp[i]=dp[i-1]+dp[i-2];
                else dp[i]=2;
            }else dp[i]=dp[i-1];
        }
        return dp[list.size()-1];
    }

    public List<Integer> count(int num){
        List<Integer> list=new ArrayList<>();
        while(num>0){
            list.add(0,num%10);
            num/=10;
        }
        return list;
    }


}
