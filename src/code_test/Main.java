package code_test;


import lfu.LFUCache2;
import org.junit.Test;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        LFUCache2 cache=new LFUCache2(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
    }
}






