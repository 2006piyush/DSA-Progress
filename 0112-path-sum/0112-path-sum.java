/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        fun(root,0,targetSum);
        return res;
    }
    boolean res = false;
    void fun(TreeNode root, int sum, int targetSum){
        if(root==null){
            return;
        }
        sum = sum + root.val;
        if(root.left==null && root.right==null ){
            if(sum==targetSum){
                res = true;
                return;
            }
        }
        fun(root.left,sum,targetSum);
        fun(root.right,sum,targetSum);
        return;
    }
}