package leetcode;

import java.util.*;

public class OpenLock752 {


    /**
     * BFS求无向图最短路径
     * @param deadends
     * @param target
     * @return
     */
    public int solution(String[] deadends, String target){
        HashSet<String> deadSet=new HashSet<>();
        for(String s:deadends) deadSet.add(s);
        if(deadSet.contains(target)||deadSet.contains("0000")) return -1;
        HashMap<String,Integer> visited=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer("0000");
        visited.put("0000",0);
        while(!queue.isEmpty()){
            String s=queue.poll();
            char[] chars=s.toCharArray();
            List<String> nexts=new ArrayList<>();
            for(int i=0;i<4;i++){
                char c=chars[i];
                int curr=Integer.parseInt(c+"");
                int pre=(curr+9)%10,next=(curr+1)%10;
                chars[i]=Character.forDigit(pre,10);
                nexts.add(new String(chars));
                chars[i]=Character.forDigit(next,10);
                nexts.add(new String(chars));
                chars[i]=c;
            }
            for(String next:nexts){
                if(!deadSet.contains(next)&&!visited.containsKey(next)){
                    visited.put(next,visited.get(s)+1);
                    queue.offer(next);
                    if(next.equals(target)) return visited.get(target);
                }
            }
        }
        return -1;
    }

}
