package leetcode;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class WiggleMaxLength376 {

    /**
     * Pair（K，V），K表示当前和上一个数字差为正值时最大值，V表示当时和上一个数字差为负值时最大值
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int n=nums.length;
        if(n<=1) return n;
        List<Pair<Integer,Integer>> dp=new ArrayList<>();
        dp.add(new Pair(1,1));
        int pre=nums[1]-nums[0];
        if(pre<0) dp.add(new Pair(1,2));
        else if(pre==0) dp.add(new Pair(1,1));
        else dp.add(new Pair(2,1));
        for(int i=2;i<n;i++){
            pre=nums[i]-nums[i-1];
            Pair<Integer,Integer> pair=dp.get(i-1);
            Integer k=pair.getKey();
            Integer v=pair.getValue();
            if(pre<0){
                dp.add(new Pair(k,k+1));
            }else if(pre==0) dp.add(pair);
            else{
                dp.add(new Pair(v+1,v));
            }
        }
        Pair<Integer,Integer> result=dp.get(dp.size()-1);
        return Math.max(result.getKey(),result.getValue());
    }

}
