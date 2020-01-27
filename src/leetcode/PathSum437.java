package leetcode;

public class PathSum437 {


    public int solution(TreeNode root,int sum){
        if(root==null) return 0;
        int res=helper(root,sum);
        res+=solution(root.left,sum);
        res+=solution(root.right,sum);
        return res;
    }

    public int helper(TreeNode root, int sum){
        if(root==null) return 0;
        int res=0;
        if(root.val==sum) res++;
        res+=helper(root.left,sum-root.val);
        res+=helper(root.right,sum-root.val);
        return res;
    }


}
