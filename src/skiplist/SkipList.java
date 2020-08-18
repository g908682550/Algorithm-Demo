package skiplist;

import org.junit.Test;

import java.util.Random;

/**
 * 跳跃表
 */
public class SkipList {

    private SkipListNode header, tail;

    private Integer length;

    private Integer level;


    public SkipListNode getHeader() {
        return header;
    }

    public SkipListNode getTail() {
        return tail;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getLevel() {
        return level;
    }

    public void setHeader(SkipListNode header) {
        this.header = header;
    }

    public void setTail(SkipListNode tail) {
        this.tail = tail;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
