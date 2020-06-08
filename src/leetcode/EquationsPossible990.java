package leetcode;

import org.junit.Test;
import unionfind.UnionFind2;

public class EquationsPossible990 {

    @Test
    public void test(){
        String[] ss={"a==b","b!=a"};
        solution(ss);
    }

    /**
     * 借助并查集，遍历一遍让相等的元素处于一个集合中，再遍历一遍判断不相等的元素
     * @param equations
     * @return
     */
    public boolean solution(String[] equations){
        UnionFind2 uf=new UnionFind2(255);
        for(String s:equations){
            char a=s.charAt(0),b=s.charAt(3);
            if(s.charAt(1)=='=') uf.unionElements(a,b);
        }
        for(String s:equations){
            char a=s.charAt(0),b=s.charAt(3);
            if(s.charAt(1)=='!'&&uf.isConnected(a,b)) return false;
        }
        return true;
    }

}
