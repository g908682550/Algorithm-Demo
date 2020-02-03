package unionfind;

/**
 * 基于树实现的并查集,仍使用数组存储，记录出每个集合的rank,在find时进行数据压缩
 */
public class UnionFind5 implements UF{

    //下标为i的元素指向哪个节点
    private int[] parent;
    private int[] rank;//rank[i]表示以i为根的集合中的深度

    public UnionFind5(int size){
        parent=new int[size];
        rank=new int[size];
        //每个节点独立指向自己
        for(int i=0;i<size;i++) {
            parent[i]=i;
            rank[i]=1;
        }

    }

    private int find(int p){
        while(parent[p]!=p) {
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
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
        if(rank[pRoot]<rank[qRoot]) parent[pRoot]=qRoot;
        else if(rank[qRoot]<rank[pRoot]) parent[qRoot]=pRoot;
        else {
            parent[qRoot]=parent[pRoot];
            rank[pRoot]+=1;
        }
    }

    @Override
    public int getSize() {
        return 0;
    }
}
