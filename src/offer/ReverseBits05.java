package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseBits05 {

    @Test
    public void test(){
        solution(2147483647);
    }

    public int solution(int num){
        List<Integer> list=new ArrayList<>();
        while(num!=0){
            if((num&1)==1) list.add(1);
            else list.add(0);
            num=num>>>1;
        }
        boolean flag=false;
        int res=1,i=0,j=0,curr=0;
        while(j<list.size()){
            if(list.get(j)==0){
                flag=true;
                curr=j;
            }else
                res=Math.max(j-i+1,res);
            j++;
            while(flag&&j<list.size()){
                if(list.get(j)==0){
                    res=Math.max(res,j-i);
                    flag=false;
                    i=curr+1;
                    j=curr+1;
                    break;
                }else{
                    res++;
                    j++;
                }
            }
        }
        return res;
    }

}
