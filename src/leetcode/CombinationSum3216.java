package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3216 {

    List<List<Integer>> result=new ArrayList<>();

    int k;

    public List<List<Integer>> solution(int k, int n){
        this.k=k;
        helper(new ArrayList<>(),1,n);
        return result;
    }

    public void helper(List<Integer> list,int count,int num){
        if(num==0&&list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>k) return;
        for(int i=count;i<=(9-(k-list.size())+1);i++){//提前剪枝
            if(num-i<0) break;
            list.add(i);
            helper(list,i+1,num-i);
            list.remove(list.size()-1);
        }
    }

}
