package lfu;

import java.util.*;;

//最不经常使用缓存机制,Map+TreeSet实现
public class LFUCache1 {

    private class LFUNode implements Comparable<LFUNode> {
        int cnt,time,key,value;
        public LFUNode(int cnt,int time,int key,int value){
            this.cnt=cnt;
            this.time=time;
            this.key=key;
            this.value=value;
        }

        @Override
        public int compareTo(LFUNode o) {
            return cnt==o.cnt?o.time-time:o.cnt-cnt;
        }

    }

    int capacity,time;
    Map<Integer, LFUNode> map=new HashMap<>();
    TreeSet<LFUNode> set=new TreeSet<>();
    public LFUCache1(int capacity){
        this.capacity=capacity;
        this.time=0;
    }

    public int get(int key){
        if(!map.containsKey(key)||capacity==0) return -1;
        LFUNode node=map.get(key);
        set.remove(node);
        node.time=time++;
        node.cnt=node.cnt+1;
        set.add(node);
        map.put(key,node);
        return node.value;
    }

    public void put(int key,int value){
        if(capacity==0) return;
        if(map.containsKey(key)){
            LFUNode node=map.get(key);
            set.remove(node);
            node.time=time++;
            node.cnt=node.cnt+1;
            node.value=value;
            map.put(key,node);
            set.add(node);
        }else{
            LFUNode node=new LFUNode(1,time++,key,value);
            if(set.size()==capacity) {
                LFUNode remove=set.pollLast();
                map.remove(remove.key);
            }
            set.add(node);
            map.put(key,node);
        }
    }

}

