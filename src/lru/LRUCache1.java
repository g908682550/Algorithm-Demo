package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 继承LinkedHashMap来实现LRU算法
 */
public class LRUCache1 extends LinkedHashMap<Integer,Integer> {

    private final int CACHE_SIZE;

    public LRUCache1(int cacheSize){
        super((int) Math.ceil(cacheSize/0.75+1),0.75f,true);
        this.CACHE_SIZE=cacheSize;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>CACHE_SIZE;
    }
}
