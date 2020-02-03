package unionfind;

/**
 * 基于树实现的并查集,仍使用数组存储
 */
public class UnionFind2 implements UF{

    //下标为i的元素指向哪个节点
    private int[] parent;

    public UnionFind2(int size){
        parent=new int[size];
        //每个节点独立指向自己
        for(int i=0;i<size;i++) parent[i]=i;
    }

    private int find(int p){
        while(parent[p]!=p) p=parent[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;
        parent[pRoot]=qRoot;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
