package leetcode;

public class MaxScoreSightseeingPair1014 {

    /**
     * 对于j而言，只关心前面的A[i]+i的最大值即可
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int result=Integer.MIN_VALUE,mx=A[0]+0;
        for(int j=1;j<A.length;j++){
            result=Math.max(result,mx+A[j]-j);
            mx=Math.max(mx,j+A[j]);
        }
        return result;
    }

}
