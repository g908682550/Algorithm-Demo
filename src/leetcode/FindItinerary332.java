package leetcode;

import org.junit.Test;

import java.util.*;

public class FindItinerary332 {

    @Test
    public void test(){
        List<List<String>> tickets=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        List<String> list3=new ArrayList<>();

        list1.add("JFK");
        list1.add("KUL");

        list2.add("JFK");
        list2.add("NRT");

        list3.add("NRT");
        list3.add("JFK");
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
        solution(tickets);
    }

    Map<String,PriorityQueue<String>> map=new HashMap<>();

    public List<String> solution(List<List<String>> tickets){
        List<String> result=new ArrayList<>();
        for(List<String> list:tickets){
            String start=list.get(0),end=list.get(1);
            if(map.containsKey(start)){
                map.get(start).add(end);
            }else{
                PriorityQueue<String> minHeap=new PriorityQueue<>();
                minHeap.add(end);
                map.put(start,minHeap);
            }
        }
        String curr="JFK";
        result.add(curr);
        while(map.size()>0){
            PriorityQueue<String> top=map.get(curr);
            if(top.size()==1) map.remove(curr);
            curr=top.poll();
            result.add(curr);
        }
        return result;
    }


}
