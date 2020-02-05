package offer;

public class LeftRotateString {

    /**
     * 前反转，后反转，整体反转
     * @param str
     * @param n
     * @return
     */
    public String solution(String str,int n){
        if(str.length()==0) return str;
        StringBuilder pre=new StringBuilder();
        StringBuilder post=new StringBuilder();
        for(int i=0;i<n;i++) pre.append(str.charAt(i));
        for(int i=n;i<str.length();i++) post.append(str.charAt(i));
        pre.reverse();
        post.reverse();
        String result=pre.append(post).reverse().toString();
        return result;
    }

}
