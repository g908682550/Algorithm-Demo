package leetcode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class LadderLength127 {

    @Test
    public void test(){
        String beginWord="hit";
        String endWord="cog";
        List<String> list=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        solution(beginWord,endWord,list);
    }

    public int solution(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String,List<String>> map=new HashMap<>();
        wordList.forEach(s->{
            for(int i=0;i<s.length();i++){
                String key=s.substring(0,i)+"*"+s.substring(i+1,s.length());
                List<String> list=map.getOrDefault(key,new ArrayList<>());
                list.add(s);
            }
        });
        Set<String> record=new HashSet<>();
        record.add(beginWord);
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            String s=curr.s;
            if(s.equals(endWord)) return curr.count;
            for(int i=0;i<s.length();i++){
                String key=s.substring(0,i)+"*"+s.substring(i+1,s.length());
                List<String> nexts=map.get(key);
                if(nexts!=null){
                    for(String next:nexts) {
                        if(!record.contains(next)) queue.add(new Pair(next,curr.count+1));
                    }
                }
            }
        }
        return 0;
    }

    class Pair{
        public String s;
        public Integer count;
        public Pair(String s,Integer count){
            this.s=s;
            this.count=count;
        }
    }

}
