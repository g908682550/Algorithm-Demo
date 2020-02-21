package offer;

import java.util.Arrays;

public class VerifyPostorder33 {

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
