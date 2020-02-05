package offer;

import org.junit.Test;

import java.util.ArrayList;

public class FindContinuousSequence {

    @Test
    public void test(){
        solution2(3);
    }

    /**
     * 暴力遍历
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> solution1(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=sum/2;i++){
            int num=0,j=i;
            list.clear();
            while(num<sum){
                sum+=j;
                list.add(j);
                j++;
            }
            if(num==sum) result.add(new ArrayList<>(list));
        }
        return result;
    }

    /**
     * 滑动窗口机制
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > solution2(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        int i=1,j=1,num=0;
        while(j<=(sum+1)/2){
            num+=j;
            list.add(j);
            j++;
            while(num>=sum&&i<j){
                if(num==sum&&list.size()>1) result.add(new ArrayList<>(list));
                num-=i;
                list.remove(0);
                i++;
            }
        }
        return result;
    }

}
