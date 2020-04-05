package lfu;

import java.util.*;


//借助两个HashMap实现
public class LFUCache2 {

    private class LFUNode{
        int freq,key,value;
        public LFUNode(int freq,int key,int value){
            this.freq=freq;
            this.key=key;
            this.value=value;
        }
    }

    int minFreq,capacity;
    Map<Integer,LinkedList<LFUNode>> freq_map=new HashMap<>();
    Map<Integer,LFUNode> key_map=new HashMap<>();

    public LFUCache2(int capacity){
        this.capacity=capacity;
        minFreq=0;
    }

    public int get(int key){
        if(capacity==0||!key_map.containsKey(key)) return -1;
        LFUNode node=key_map.get(key);
        key_map.remove(node.key);
        LinkedList<LFUNode> curr=freq_map.get(node.freq);
        curr.remove(node);
        if(curr.size()==0&&minFreq==node.freq){
            minFreq++;
            freq_map.remove(node.freq);
        }
        node.freq=node.freq+1;
        key_map.put(key,node);
        if(!freq_map.containsKey(node.freq)){
            LinkedList<LFUNode> list=new LinkedList<>();
            list.addFirst(node);
            freq_map.put(node.freq,list);
        }else{
            freq_map.get(node.freq).addFirst(node);
        }
        return node.value;
    }

    public void put(int key,int value){
        if(capacity==0) return;
        if(key_map.containsKey(key)){
            LFUNode node=key_map.get(key);
            key_map.remove(node.key);
            LinkedList<LFUNode> curr=freq_map.get(node.freq);
            curr.remove(node);
            if(curr.size()==0&&minFreq==node.freq) {
                minFreq++;
                freq_map.remove(node.freq);
            }
            node.value=value;
            node.freq=node.freq+1;
            key_map.put(key,node);
            if(!freq_map.containsKey(node.freq)){
                LinkedList<LFUNode> list=new LinkedList<>();
                list.addFirst(node);
                freq_map.put(node.freq,list);
            }else{
                freq_map.get(node.freq).addFirst(node);
            }
        }else{
            if(key_map.size()==capacity){
                LinkedList<LFUNode> curr=freq_map.get(minFreq);
                LFUNode node = curr.removeLast();
                if(curr.size()==0) freq_map.remove(node.freq);
                key_map.remove(node.key);
            }
            LFUNode newNode=new LFUNode(0,key,value);
            minFreq=0;
            if(freq_map.containsKey(0)){
                freq_map.get(0).addFirst(newNode);
            }else{
                LinkedList<LFUNode> list=new LinkedList<>();
                list.addFirst(newNode);
                freq_map.put(0,list);
            }
            key_map.put(key,newNode);
        }
    }
}


