package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Rob337 {

    /**
     * 递归，当前节点的最大值为(左右子节点之和)和（自身与左子节点的左右子节点与右子节点的左右子节点之和）的最大值
     * @param root
     * @return
     */
    public int solution(TreeNode root){
        if(root==null) return 0;
        int val=root.val;
        if(root.left!=null) val+=solution(root.left.left)+solution(root.left.right);
        if(root.right!=null) val+=solution(root.right.left)+solution(root.right.right);
        return Math.max(solution(root.left)+solution(root.right),val);
    }

    Map<TreeNode,Integer> map=new HashMap<>();

    /**
     * 创建一个额外的空间进行保存已经计算过的节点
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int val=root.val;
        if(root.left!=null) val+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null) val+=rob(root.right.left)+rob(root.right.right);
        val=Math.max(val,rob(root.left)+rob(root.right));
        map.put(root,val);
        return val;
    }

    /**
     * 很巧妙的一种思路，利用2个大小的res来保存当前节点两种情况所能获得的最大值（res[0]表示不使用当前节点，res[1]表示使用当前节点）
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res=helper(root);
        return Math.max(res[0],res[1]);
    }

    public int[] helper(TreeNode node){
        int[] res=new int[2];
        if(node==null) return res;
        int[] left=helper(node.left);
        int[] right=helper(node.right);
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=node.val+left[0]+right[0];
        return res;
    }
}
