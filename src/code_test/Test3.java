package code_test;

import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=scanner.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        int maxInt=0,maxCount=0;
        for(int i=0;i<n;i++){
            int num=scanner.nextInt();
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>maxCount){
                maxInt=num;
                maxCount=map.get(num);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num=entry.getKey(),count=entry.getValue();
            if(map.containsKey(num-x)) count+=map.get(num-x);
            if(count>maxCount) maxCount=count;
        }
        System.out.println(maxCount);
    }

}
