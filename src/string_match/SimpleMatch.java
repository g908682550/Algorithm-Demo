package string_match;

public class SimpleMatch {
    public static int method(String s1,String s2){
        int l1=s1.length();
        int l2=s2.length();
        for(int i=0;i<=l1-l2;i++){
            int j;
            for(j=0;j<l2;j++) if(s1.charAt(i+j)!=s2.charAt(j)) break;
            if(j==l2) return i;
        }
        return -1;
    }
}
