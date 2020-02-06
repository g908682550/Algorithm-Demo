package offer;

import java.util.ArrayList;

public class LastRemaining_Solution {

    /**
     * 数组模拟约瑟夫环问题
     * @param n
     * @param m
     * @return
     */
    public int solution(int n, int m){
        if(n==0) return -1;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(i);
        int curr=0;
        while(list.size()>1){
            int index=(curr+m-1)%list.size();
            list.remove(index);
            curr=index;
        }
        return list.get(0);
    }

}
