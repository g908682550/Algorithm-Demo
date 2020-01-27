package leetcode;

public class SortedArrayToBST108 {


    public TreeNode solution(int[] nums){
        int n=nums.length;
        if(n==0) return null;
        return helper(nums,0,n-1);
    }

    public TreeNode helper(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=(left+right+1)>>>1;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=helper(nums,left,mid-1);
        node.right=helper(nums,mid+1,right);
        return node;
    }

}
