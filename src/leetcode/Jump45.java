package leetcode;

import org.junit.Test;

public class Jump45 {

    @Test
    public void test(){
        int[] nums={5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8};
        solution(nums);
    }

    public int solution(int[] nums){
        int curr=0,result=0,n=nums.length;
        if(n==0) return 0;
        while(curr<n){
            if(curr==n-1) return result;
            int next=curr+nums[curr];
            if(next>=n-1) return result+1;
            int total=next+nums[next];
            int temp=next;
            while(temp>curr){
                if(temp+nums[temp]>total){
                    next=temp;
                    total=next+nums[next];
                }
                temp--;
            }
            result++;
            curr=next;
        }
        return result;
    }

}
