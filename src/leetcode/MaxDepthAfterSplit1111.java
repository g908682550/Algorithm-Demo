package leetcode;

public class MaxDepthAfterSplit1111 {

    //括号一定有效，则奇数位"("赋予0，偶数位"("赋予1
    public int[] solution(String seq) {
        int[] res=new int[seq.length()];
        int idx=0;
        for(char c:seq.toCharArray()){
            res[idx]=c=='('?(idx&1):((idx+1)&1);
            idx++;
        }
        return res;
    }

}
