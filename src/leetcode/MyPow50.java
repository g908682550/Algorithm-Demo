package leetcode;

public class MyPow50 {

    public double solution(double x, int n) {
        if(n<0) return 1/fastpow(x,-n);
        else return fastpow(x,n);
    }
    public double fastpow(double x,int n){
        if(n==0) return 1;
        if(n==1) return x;
        double sub=fastpow(x,n/2);
        if(n%2==0) return sub*sub;
        else return x*sub*sub;
    }

}
