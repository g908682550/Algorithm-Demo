package tree;

import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root=new Node();
        size=0;
    }

    private int getSize(){
        return size;
    }

    //向Trie中添加一个单词
    public void add(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.next.get(c)==null) curr.next.put(c,new Node());
            curr=curr.next.get(c);
        }
        if(!curr.isWord) {
            curr.isWord=true;
            size++;
        }
    }

    public boolean contains(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.next.get(c)==null) return false;
            curr=curr.next.get(c);
        }
        return curr.isWord;
    }

    public boolean isPrefix(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(curr.next.get(c)==null) return false;
            curr=curr.next.get(c);
        }
        return true;
    }


}
