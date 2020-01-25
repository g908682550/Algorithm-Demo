package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator341 implements Iterator<Integer> {
    List<Integer> list=new ArrayList<>();

    Iterator<Integer> iter;

    public NestedIterator341(List<NestedInteger> nestedList) {
        helper(nestedList);
        iter=list.iterator();
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    public void helper(List<NestedInteger> nest){
        for(NestedInteger n:nest){
            if(n.getList()!=null) helper(n.getList());
            if(n.isInteger()) list.add(n.getInteger());
        }
    }
}

interface NestedInteger{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
