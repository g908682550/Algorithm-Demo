package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate118 {

    /**
     * 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> solution(int numRows){
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0) return result;
        result.add(new ArrayList<>(Arrays.asList(1)));
        while(--numRows>0){
            List<Integer> last=result.get(result.size()-1);
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<last.size();i++){
                if(i==0) list.add(last.get(i));
                if(i==last.size()-1){
                    list.add(last.get(i));
                    break;
                }
                list.add(last.get(i)+last.get(i+1));
            }
            result.add(list);
        }
        return result;
    }

}
