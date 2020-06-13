package leetcode;

import java.util.*;

public class WatchedVideosByFriends1311 {

    /**
     * bfs加排序
     * @param watchedVideos
     * @param friends
     * @param id
     * @param level
     * @return
     */
    public List<String> solution(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> result=new ArrayList<>();
        boolean[] flag=new boolean[friends.length];
        Map<String,Integer> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int curr=queue.poll();
                for(int num:friends[curr]){
                    if(!flag[num]){
                        flag[num]=true;
                        queue.add(num);
                    }
                }
            }
            if(--level==0) break;
        }
        List<Integer> level_friends=new ArrayList<>(queue);
        for(int num:level_friends){
            if(num!=id){
                List<String> videos=watchedVideos.get(num);
                for(String s:videos){
                    map.put(s,map.getOrDefault(s,0)+1);
                }
            }
        }
        Queue<Pair> pqueue=new PriorityQueue<>((a,b)->{
            if(a.num!=b.num) return a.num-b.num;
            else return a.s.compareTo(b.s);
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pqueue.add(new Pair(entry.getKey(),entry.getValue()));
        }
        while(!pqueue.isEmpty()){
            result.add(pqueue.poll().s);
        }
        return result;
    }

    private class Pair{

        String s;
        Integer num;

        public Pair(String s,Integer num){
            this.s=s;
            this.num=num;
        }
    }

}
