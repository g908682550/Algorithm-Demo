package offer;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.Arrays;

public class VerifyPostorder33 {

    @Test
    public void test(){
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(6);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        int[] nums={1,3,2,6,5};
        solution(nums);
    }

    /**
     * 根据后序遍历的特征，前部分为左子树，后部分为右子树，最后为首元素，前部分全部小于首元素，后部分全部大于首元素
     * @param postorder
     * @return
     */
    public boolean solution(int[] postorder){
        int n=postorder.length;
        if(n==0) return true;
        int head=postorder[n-1];
        int i,j;
        for(i=0;i<n-1;i++) if(postorder[i]>head) break;
        for(j=i;j<n-1;j++) if(postorder[j]<head) return false;
        return solution(Arrays.copyOfRange(postorder,0,i))&&solution(Arrays.copyOfRange(postorder,i,n-1));
    }

}
