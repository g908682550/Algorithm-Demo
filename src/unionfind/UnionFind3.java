package unionfind;

/**
 * 基于树实现的并查集,仍使用数组存储，记录出每个集合的大小
 */
public class UnionFind3 implements UF{

    //下标为i的元素指向哪个节点
    private int[] parent;
    private int[] sz;//sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size){
        parent=new int[size];
        sz=new int[size];
        //每个节点独立指向自己
        for(int i=0;i<size;i++) {
            parent[i]=i;
            sz[i]=1;
        }

    }

    private int find(int p){
        while(parent[p]!=p) p=parent[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    /**
     * 让大小较小的子集指向较大的
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;
        if(sz[pRoot]<sz[qRoot]) {
            parent[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }
        else {
            parent[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }
    }

    @Override
    public int getSize() {
        return 0;
    }
}
