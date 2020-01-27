package leetcode;

public class DeleteNode450 {

    public int preNode(TreeNode node){
        node=node.left;
        while(node.right!=null) node=node.right;
        return node.val;
    }

    public int successNode(TreeNode node){
        node=node.right;
        while(node.left!=null) node=node.left;
        return node.val;
    }

    /**
     * 二分搜索树的删除操作
     * @param root
     * @param key
     * @return
     */
    public TreeNode solution(TreeNode root, int key){
        if(root==null) return null;
        if(key>root.val)
            //在右子树删除，返回删除后右子树的头节点
            root.right=solution(root.right,key);
        else if(key<root.val)
            //在左子树删除，返回删除后左子树的头节点
            root.left=solution(root.left,key);
        else{
            //叶子节点直接删除
            if(root.left==null&&root.right==null) root=null;
            //如果当前节点的右节点不为空，找到其的后一个节点（大于它的最小节点），赋值给自身，并且在右子树中删除该节点后将右子树返回，赋给自己的右子树
            else if(root.right!=null){
                root.val=successNode(root);
                root.right=solution(root.right,root.val);
            }else{
                //如果当前节点的左节点不为空，找到其的前一个节点（小于它的最大节点），赋值给自身，并在左子树中删除这个节点，将删除后的子树赋值给该节点的左子树
                root.val=preNode(root);
                root.left=solution(root.left,root.val);
            }
        }
        return root;
    }




}
