package offer;

public class LastRemaining62 {

    /**
     * 约瑟夫环问题，从最后的索引求出最开始的索引位置
     * @param n
     * @param m
     * @return
     */
    public int solution(int n, int m) {
        int p=0;
        for(int i=2;i<=n;i++){
            p=(p+m)%i;
        }
        return p;
    }

}
