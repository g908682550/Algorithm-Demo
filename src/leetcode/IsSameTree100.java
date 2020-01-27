package leetcode;

public class IsSameTree100 {


    public boolean solution(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        return (p.val==q.val)&&(solution(p.left,q.left))&&(solution(p.right,q.right));
    }

}
