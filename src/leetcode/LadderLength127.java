package leetcode;
import javafx.util.Pair;

import java.util.*;

public class LadderLength127 {


    public int solution1(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)) return 0;
        int length=beginWord.length();
        HashMap<String,List<String>> map=new HashMap<>();//创建一个map，改map用于查找当前字符串下一个能匹配的所有字符串
        wordList.forEach(s->{
            for(int i=0;i<length;i++){
                String key=s.substring(0,i)+"*"+s.substring(i+1,length);
                List<String> value=map.getOrDefault(key,new ArrayList<String>());
                value.add(s);
                map.put(key,value);
            }
        });
        //图的广度优先遍历算法
        Queue<Pair<String,Integer>> queue=new LinkedList<>();//用于记录当前字符串以及走过的路径长度
        queue.offer(new Pair(beginWord,1));
        HashMap<String,Boolean> record=new HashMap<>();//用于记录访问过的元素
        record.put(beginWord,true);
        while(queue.size()>0){
            Pair pair=queue.poll();
            String s=(String)pair.getKey();
            Integer ladder=(Integer)pair.getValue();
            for(int i=0;i<length;i++){//找到所有可能的下个字符串进行遍历
                String next=s.substring(0,i)+"*"+s.substring(i+1,length);
                for(String ss:map.getOrDefault(next,new ArrayList<>())){//当前能匹配到的list
                    if(ss.equals(endWord)) return ladder+1;//当前字符串相等，返回
                    if(!record.getOrDefault(ss,false)){//之前没有出现过，进行下一次遍历
                        record.put(ss,true);
                        queue.offer(new Pair(ss,ladder+1));
                    }
                }
            }
        }
        return 0;
    }

}
