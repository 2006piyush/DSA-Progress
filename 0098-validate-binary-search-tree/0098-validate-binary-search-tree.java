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
    TreeNode prev = null;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return ans;
        }
        isValidBST(root.left);
        if(prev==null){
            prev = root;
        }
        else{
            if(root.val<=prev.val){
                ans = false;
            }
            else{
                prev = root;
            }
        }
        isValidBST(root.right);
        return ans;
    }
}