package leetcode;

import java.util.ArrayList;
import java.util.List;

public class kidsWithCandies1431 {

    public List<Boolean> solution(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> result=new ArrayList<>();
        for(int num:candies){
            if(num>max) max=num;
        }
        for(int num:candies){
            if(num+extraCandies>=max) result.add(new Boolean(true));
            else result.add(new Boolean(false));
        }
        return result;
    }

}
