package leetcode;

import org.junit.Test;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate220 {

    @Test
    public void test(){
        int[] nums={1,2,3,1};
        System.out.println(solution1(nums, 0, 1));
    }

    /**
     * 借助于TreeSet，与219相似，在set里找到最接近的那个数字进行判断
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean solution1(int[] nums, int k, int t){
        int n=nums.length,i=0,j=0;
        TreeSet<Long> set=new TreeSet<>();
        while(j<n){
            long curr=(long)nums[j];
            if(j<=i+k){
                //找到大于等于curr的第一个值，不存在则返回null
                Long more=set.ceiling(curr);
                //找到小于等于curr的第一个值，不存在则返回null
                Long less=set.floor(curr);
                if(more!=null&&more-curr<=t) return true;
                if(less!=null&&curr-less<=t) return true;
                set.add(curr);
                j++;
            }else{
                set.remove((long)nums[i]);
                i++;
            }
        }
        return false;
    }

}
