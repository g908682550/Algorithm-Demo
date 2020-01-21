package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints149 {


    @Test
    public void test(){
        int[][] points={{1,1},{1,2},{1,3}};
        System.out.println(solution1(points));
    }

    /**
     * 思路：使用x@y表示斜率，其中x和y都是化简后的，每次以一个点为起始点，计算以该点为起始点的所有直线里点最多的那个
     * @param points
     * @return
     */
    public int solution1(int[][] points){
        if(points.length<3) return points.length;
        int n=points.length,res=0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int[] point1=points[i];
            int max=0,duplicate=0;
            map.clear();
            for(int j=i+1;j<n;j++){
                int[] point2=points[j];
                int x=point2[0]-point1[0],y=point2[1]-point1[1];
                if(x==0&&y==0) {
                    duplicate++;
                    continue;
                }
                //求x和y的最大公因数
                int gcd=gcd(x,y);
                x=x/gcd;
                y=y/gcd;
                String key=x+"@"+y;
                map.put(key,map.getOrDefault(key,0)+1);
                max=Math.max(max,map.get(key));
            }
            res=Math.max(res,max+duplicate+1);
        }
        return res;
        }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
