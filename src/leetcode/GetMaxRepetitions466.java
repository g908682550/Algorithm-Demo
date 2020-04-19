package leetcode;

public class GetMaxRepetitions466 {

    /**
     * 暴力循环遍历
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int solution(String s1,int n1, String s2, int n2){
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int index=0,res=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<s1.length();j++){
                if(c2[index]==c1[j]) index++;
                if(index==c2.length){
                    res++;
                    index=0;
                }
            }
        }
        return res/n2;
    }

}
