/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        int left=helper(root.left,p,q);
        int right=helper(root.right,p,q);
        if(left==2){
            return lowestCommonAncestor(root.left,p,q);
        }else if(right==2){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;  
    }
    public int helper(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return 0;
        int cur=0;
        if(root.val==p.val||root.val==q.val){
         cur=1;
        }
        int left=helper(root.left,p,q);
        int right=helper(root.right,p,q);
        return left+right+cur;
    }

}