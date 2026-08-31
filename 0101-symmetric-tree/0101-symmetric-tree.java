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
    public boolean isSymmetric(TreeNode root) {
        return isSymmTree(root.left, root.right);
    }
    boolean isSymmTree(TreeNode p, TreeNode q){
           if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean t1 = isSymmTree(p.left,q.right);
        boolean t2 = isSymmTree(p.right,q.left);
        if(t1==true && t2==true){
            return true;
        }
        return false;
    }
}