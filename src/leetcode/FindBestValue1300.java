package leetcode;

import java.util.Arrays;

public class FindBestValue1300 {

    public int solution(int[] arr, int target) {
        Arrays.sort(arr);
        int size=arr.length,sum=0;
        for(int i=0;i<size;i++){
            double davg=(double)(target-sum)/(size-i);
            int avg=(int)davg;
            if(davg-avg>0.5) avg=avg+1;
            if(arr[i]>avg){
                return avg;
            }
            sum+=arr[i];
        }
        return arr[size-1];
    }

}
