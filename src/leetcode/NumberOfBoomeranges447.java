package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomeranges447 {

    @Test
    public void test(){
        int[][] points={{0,0},{1,0},{2,0}};
        System.out.println(solution1(points));
    }


    /**
     * 遍历每一个点，分别计算其余点到这个点的距离，加入map中
     * @param points
     * @return
     */
    public int solution1(int[][] points){
        int length=points.length,result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            int[] curr=points[i];
            map.clear();
            for(int j=0;j<length;j++){
                if(j==i) continue;
                int[] other=points[j];
                int dif=(other[0]-curr[0])*(other[0]-curr[0])+(other[1]-curr[1])*(other[1]-curr[1]);
                if(map.containsKey(dif)) map.put(dif,map.get(dif)+1);
                else map.put(dif,1);
            }
            result+=count(map);
        }
        return result;
    }
    public int count(Map<Integer,Integer> map){
        int result=0;
        for(Integer i:map.values()) if(i>1) result=result+i*(i-1);
        return result;
    }
}
