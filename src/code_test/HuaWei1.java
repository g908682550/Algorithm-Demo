package code_test;

import java.util.*;
//N个字符，最长为L，求可能出现的各种排列的个数。例如N=2，L=3的时候，有'0','1','00','01','10','11','000','001'....'111'共14个字符串
public class HuaWei1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int N=scanner.nextInt(),L=scanner.nextInt();
            if(N==0&&L==0) break;
            if(L==0){
                System.out.println(0);
                continue;
            }
            else{
                long res=N;long pre=N;
                for(int i=2;i<=L;i++){
                    long curr=(pre*N)%1000000007;
                    pre=curr;
                    res=(res+curr)%1000000007;
                }
                System.out.println(res);
            }
        }
    }

}
