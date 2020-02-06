package offer;

import org.junit.Test;

import java.util.Arrays;

public class IsContinuous {

    @Test
    public void test(){
        int[] nums={1,3,2,5,4};
        solution(nums);
    }

    /**
     * 排序后遍历，0填充
     * @param numbers
     * @return
     */
    public boolean solution(int[] numbers){
        Arrays.sort(numbers);
        int num=0;
        for(int i=0;i<numbers.length;i++) if(numbers[i]==0) num++;
        int pre=numbers[num];
        int index=num+1;
        while(index<numbers.length){
            int curr=numbers[index];
            if(curr-pre==1){
                index++;
            }else{
                if(num==0) return false;
                else{
                    num--;
                    pre=pre+1;
                }
            }
        }
        return true;
    }

}
