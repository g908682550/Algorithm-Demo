package tree;

/**
 * 线段树，构造一个满二叉树，非叶子节点的值为其孩子结点的相应业务结果,可解决Leetcode307号问题
 * @param <E>
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;


    /**
     * 构造函数中创建一个副本保存传入的数组
     * @param arr
     */
    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger=merger;
        data=(E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++) data[i]=arr[i];
        //构造一个满二叉树，需要4*n大小的空间
        tree=(E[])new Object[arr.length*4];
        buildSegmentTree(0,0,data.length-1);
    }

    //在treeIndex的位置创建表示区间[l,r]的线段树
    private void buildSegmentTree(int treeIndex,int l,int r){
        if(l==r) {
            tree[treeIndex]=data[l];
            return;
        }
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        int mid=l+(r-l)/2;
        //创建其左子树线段树
        buildSegmentTree(leftTreeIndex,l,mid);
        //创建右子树线段树
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public E query(int queryL,int queryR){
        if(queryL<0|queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR) throw new IllegalArgumentException("error");
        return query(0,0,data.length-1,queryL,queryR);
    }

    /**
     * 以treeIndex为根的线段树中[l...r]的范围内，搜索区间[queryL...queryR]的值
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l==queryL&&r==queryR) return tree[treeIndex];
        int mid=l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        if(queryL>=mid+1) return query(rightTreeIndex,mid+1,r,queryL,queryR);
        if(queryR<=mid) return query(leftTreeIndex,l,mid,queryL,queryR);
        return merger.merge(query(leftTreeIndex,l,mid,queryL,mid),query(rightTreeIndex,mid+1,r,mid+1,queryR));
    }

    public void set(int index,E e){
        if(index<0||index>=data.length) throw new IllegalArgumentException("error");
        data[index]=e;
        set(0,0,data.length-1,index,e);
    }

    public void set(int treeIndex,int l,int r,int index,E e){
        if(l==r){
            tree[treeIndex]=e;
            return;
        }
        int mid=l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        if(index>=mid+1) set(rightTreeIndex,mid+1,r,index,e);
        if(index<=mid) set(leftTreeIndex,l,mid,index,e);
        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index<0||index>data.length) throw new IllegalArgumentException("error");
        return data[index];
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }
}

interface Merger<E>{
    E merge(E a,E b);
}
