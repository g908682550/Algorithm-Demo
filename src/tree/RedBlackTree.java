package tree;

/**
 * 红黑树的一些性质（根据2-3树可得下列性质）
 * 1、每个红链接均为3节点的左节点，红链接均为左链接
 * 2、没有任何一个结点同时和两条红链接相连
 * 3、该树是完美黑色平衡的，即任意空链接到根节点的路径上的黑链接数量相同
 *
 *
 * 算法导论中的红黑树定义：
 * 1、每个节点都是红色或者是黑色的
 * 2、根节点是黑色的
 * 3、每一个叶子节点（最后的空节点）是黑色的
 * 4、如果一个节点是红色的，那么它的孩子节点都是黑色的
 * 5、从任意一个节点到叶子节点，经过的黑色节点都是一样的
 *
 * 红黑树最大的优势在于它的添加和删除操作
 */
public class RedBlackTree {
    //红黑树的插入算法实现
    private Node root;
    private static final boolean RED=true;
    private static final boolean BLACK=false;

    public void put(String key,Integer val){
        //查找key，找到则更新其值，否则为它创建一个结点
        root=put(root,key,val);
        //根结点始终为黑色，即作为2结点的右结点或者是3结点拆分后的父结点
        root.color=BLACK;
    }

    //具体的插入操作，满足以下3个条件
    //1、如果右子节点是红色的而左子结点是黑色的，进行左旋转(向2节点的右边插入节点时及向3节点的中间插入节点时）
    //2、如果左子节点是红色的且它的左子结点也是红色的，进行右旋转(向3节点最左边插入时)
    //3、左右子节点均为红色，进行颜色转化（3节点拆分2节点的过程）
    private Node put(Node h,String key,Integer val){
        if(h==null) return new Node(key,val,1,RED);
        int cmp=val.compareTo(h.val);
        if(cmp<0) h.left=put(h.left,key,val);
        else if(cmp>0) h.right=put(h.right,key,val);
        else h.val=val;

        if(isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
        if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
        if(isRed(h.right)&&isRed(h.left)) flipColors(h);

//        h.N=size(h.left)+size(h.right)+1;
        return h;
    }

    private boolean isRed(Node h){
        if(h==null) return false;
        return h.color==RED;
    }
    //左旋操作，旋转后的子节点均为红色，父节点继承之前父节点的颜色并返回
    private Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
//        x.N=h.N;
//        h.N=1+size(h.left)+size(h.right);
        return x;
    }
    //右旋操作，旋转后的子节点均为红色，父节点继承之前父节点的颜色并返回
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
//        x.N=h.N;
//        h.N=1+size(h.left)+size(h.right);
        return x;
    }
    //变色操作，将父节点变为红色，子节点变为黑色
    // (该步骤意思是将3结点进行拆分成2个2节点的操作，此种情况下左右节点都为红色，拆分后为黑色，于是多出一个结点来，结点插入时默认都为红色，因此赋予其红色）
    private void flipColors(Node h){
        h.color=RED;
        h.left.color= BLACK;
        h.right.color=BLACK;
    }
//    public int size(){ return size(root);}
//    private int size(Node x){if(x==null) return 0; else return x.N;}

}

class Node{
    String key;
    Integer val;
    //左子节点，右子节点
    Node left,right;
////    //该树的子树中的结点个数
//    Integer N;
    boolean color;
    public Node(String key,Integer val,int N,boolean color){
        this.key=key;
        this.val=val;
//        this.N=N;
        this.color=color;
    }
}
