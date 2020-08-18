package leetcode;

import org.junit.Test;

public class LongestCommonPrefix14 {

    @Test
    public void test(){
        String[] strs={"flower","flow","flight"};
        solution1(strs);
    }

    /**
     * 一个字符一个字符进行遍历
     * @param strs
     * @return
     */
    public String solution1(String[] strs) {
        if(strs.length==0) return "";
        int min=Integer.MAX_VALUE;
        for(String str:strs){
            min=Math.min(min,str.length());
        }
        boolean flag=false;
        int j=0;
        while(j<min){
            for(int i=1;i<strs.length;i++){
                if(strs[i].charAt(j)!=strs[i-1].charAt(j)){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
            j++;
        }
        return strs[0].substring(0,j);
    }

    /**
     * 找出最短字符，再二分对比
     * @param strs
     * @return
     */
    public String solution2(String[] strs) {
        if(strs.length==0) return "";
        int min=Integer.MAX_VALUE;
        String min_str="";
        for(String str:strs){
            if(str.length()<min){
                min_str=str;
                min=str.length();
            }
        }
        int left=0,right=min;
        while(left<right){
            int mid=left+(right-left+1)/2;
            String temp=min_str.substring(0,mid);
            if(!isTrue(strs,temp)){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return min_str.substring(0,left);
    }

    public boolean isTrue(String[] strs,String temp){
        for(String str:strs){
            if(!str.startsWith(temp)) return false;
        }
        return true;
    }

}
