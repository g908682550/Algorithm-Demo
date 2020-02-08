package lru;

import java.util.HashMap;
import java.util.Map;

class LRUNode{
    String key;
    Object value;
    LRUNode next;
    LRUNode pre;

    public LRUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    Map<String,LRUNode> map=new HashMap<>();
    LRUNode head;
    LRUNode tail;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public Object get(String key) {
        LRUNode node=map.get(key);
        if(node!=null){
            removeAndInsert(node);
            return node.value;
        }
        return null;
    }

    public void put(String key, Object value) {
        if(head==null){
            head=new LRUNode(key,value);
            tail=head;
            map.put(key,head);
        }
        LRUNode node=map.get(key);
        if(node!=null){
            node.value=value;
            removeAndInsert(node);
        }else{
            LRUNode curr=new LRUNode(key,value);
            //容量已满，需要删除元素
            if(map.size()==capacity){
                map.remove(tail.key);
                if(map.size()!=0){
                    tail=tail.pre;
                    tail.next=null;
                }else{
                    tail=null;
                    head=null;
                    this.put(key,value);
                }
            }
            map.put(key,curr);
            curr.next=head;
            head.pre=curr;
            head=curr;
        }
    }

    private void removeAndInsert(LRUNode node) {
        if(node==head) return;
        else if(node==tail){
            tail=tail.pre;
            tail.next=null;
        }else{
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        node.next=head;
        node.pre=null;
        head.pre=node;
        head=node;
    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(1);
        lruCache.put("1",1);
        System.out.println(lruCache.get("1"));
        lruCache.put("3",3);
        System.out.println(lruCache.get("2"));
        lruCache.put("4",4);
        System.out.println(lruCache.get("1"));
        System.out.println(lruCache.get("3"));
        System.out.println(lruCache.get("4"));
    }

}
