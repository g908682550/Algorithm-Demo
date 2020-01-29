package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch401 {

    int[] nums={1,2,4,8,16,32,60,120,240,480};
    List<String> result=new ArrayList<>();
    int n;

    /**
     * 借助二进制运算
     * @param num
     * @return
     */
    public List<String> solution(int num){
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(count(i)+count(j)==num){
                    String s=i+":"+(j<10?"0"+j:j+"");
                    result.add(s);
                }
            }
        }
        return result;
    }

    /**
     * 计算一个数二进制中的1的个数
     * @param num
     * @return
     */
    public int count(int num){
        int count=0;
        while(num!=0){
            if((num&1)!=0) count++;
            num=num>>>1;
        }
        return count;
    }

    public int count2(int num){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }


}
