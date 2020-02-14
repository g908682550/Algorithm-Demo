package offer;

import org.junit.Test;

public class MinArray11 {

    @Test
    public void test(){
        int[] nums={3,1,3};
        solution(nums);
    }

    public int solution(int[] numbers){
        if(numbers.length==0) return 0;
        int i=0,j=numbers.length-1;
        while(i<j){
            int mid=i+(j-i)/2;
            if(numbers[mid]>numbers[j]) i=mid+1;
            else if(numbers[mid]==numbers[j]) j=j-1;
            else j=mid;
        }
        return numbers[j];
    }


}
