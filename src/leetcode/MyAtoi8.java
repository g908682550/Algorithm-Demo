package leetcode;

public class MyAtoi8 {

    public int solution(String str) {
        int min=Integer.MIN_VALUE,max=Integer.MAX_VALUE,sign=1,index=0,n=str.length(),res=0;
        while(index<n&&str.charAt(index)==' ') index++;
        if(index==n) return res;
        if(str.charAt(index)=='+') index++;
        else if(str.charAt(index)=='-'){
            sign=-1;
            index++;
        }
        while(index<n){
            char c=str.charAt(index);
            if(c<48||c>57) return res;
            if(res>max/10||(res==max/10&&(c-48)>max%10)) return max;
            if(res<min/10||(res==min/10&&(c-48)>-(min%10))) return min;
            res=res*10+sign*(c-48);
            index++;
        }
        return res;
    }
}
