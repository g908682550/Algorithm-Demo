package string_match;

/**
 * KMP算法实现，基于《算法4》
 */
public class KMP {
    //有限状态自动机，该数组只和匹配串有关
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        //dp[状态][字符]=下个状态
        dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        //该数组的构造过程，重点理解
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++)
                //此处先将该状态更新为为X状态（影子状态，即最大公共前缀）遇到该字符时所转移的状态
                dp[j][c] = dp[X][c];
            //如果c匹配了下一个字符，则更新为下一个状态,如果不匹配，则使用影子状态的状态。
            dp[j][pat.charAt(j)] = j + 1;
            //更新影子状态,即为最长公共前缀
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        //pat的初始状态为0
        int j = 0;
        //i永远不回退，只有状态j在改变
        for (int i = 0; i < N; i++) {
            //状态j进行改变
            j = dp[j][txt.charAt(i)];
            //如果状态j到达终止态，匹配成功返回。
            if (j == M) return i - M + 1;
        }
        return -1;
    }

}
