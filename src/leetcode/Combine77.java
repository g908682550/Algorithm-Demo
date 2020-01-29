package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {

    @Test
    public void test(){
        solution(4,2);
    }


    int n,k;

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution(int n,int k){
        this.n=n;
        this.k=k;
        helper(new ArrayList<>(),1);
        return result;
    }

    public void helper(List<Integer> list,int count){
        if(list.size()==k) {//当list集合大小达到k时返回
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=count;i<=(n-(k-list.size())+1);i++){//做一个剪枝优化，当前只需循环到n-(k-list.size())+1数字处
            list.add(i);
            helper(list,i+1);//这里和排列不一样，需要向下传递当前i，即后面的只考虑后面的
            list.remove(list.size()-1);
        }
    }

}
