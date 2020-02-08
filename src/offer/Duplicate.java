package offer;

import java.util.HashMap;

public class Duplicate {

    public boolean solution(int numbers[],int length,int [] duplication){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++) map.put(numbers[i],map.getOrDefault(numbers[i],0)+1);
        for(int i=0;i<length;i++)
            if(map.get(numbers[i])>1){
                duplication[0]=numbers[i];
                return true;
            }
        return false;
    }

}
