package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumLengthEncoding820 {

    @Test
    public void test(){

    }

    /**
     * 前缀树，随后判断字符是否出现过
     * @param words
     * @return
     */
    public int solution(String[] words) {
        int result=0;
        Arrays.sort(words,(a, b)->b.length()-a.length());
        Trie trie=new Trie();
        for(String word:words){
            if(!trie.search(word)){
                trie.insert(word);
                result+=word.length()+1;
            }
        }
        return result;
    }

}

class Trie{
    private class Node{
        Map<Character,Node> next;
        public Node(){
            next=new HashMap<>();
        }
    }
    Node root=new Node();
    public void insert(String word){
        Node curr=root;
        for(int i=word.length()-1;i>=0;i--){
            char c=word.charAt(i);
            if(!curr.next.containsKey(c)) curr.next.put(c,new Node());
            curr=curr.next.get(c);
        }
    }
    public boolean search(String word){
        Node curr=root;
        for(int i=word.length()-1;i>=0;i--){
            char c=word.charAt(i);
            if(!curr.next.containsKey(c)) return false;
            curr=curr.next.get(c);
        }
        return true;
    }
}
