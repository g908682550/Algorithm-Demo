package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumbersWithSum {


    @Test
    public void test(){
        int[] nums={1,2,4,7,11,15};
        System.out.println(solution(nums,11));
    }

    /**
     * 双指针，有序数组两数之和
     * @param array
     * @param sum
     * @return
     */
    public List<Integer> solution(int[] array,int sum){
        int i=0,j=array.length-1,num=0;
        while(i<j){
            num=array[i]+array[j];
            if(num==sum) return new ArrayList<>(Arrays.asList(array[i],array[j]));
            else if(num>sum){
                j--;
            }else{
                i++;
            }
        }
        return new ArrayList<>();
    }

}
