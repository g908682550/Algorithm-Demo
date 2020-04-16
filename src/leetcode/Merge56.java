package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge56 {

    /**
     * 排序后合并
     * @param intervals
     * @return
     */
    public int[][] solution(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int min=intervals[i][0],max=intervals[i][1];
            while(i+1<intervals.length&&max>=intervals[i+1][0]){
                max=Math.max(max,intervals[i+1][1]);
                i++;
            }
            result.add(new ArrayList<>(Arrays.asList(min,max)));
        }
        int[][] res=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0]=result.get(i).get(0);
            res[i][1]=result.get(i).get(1);
        }
        return res;
    }

}
