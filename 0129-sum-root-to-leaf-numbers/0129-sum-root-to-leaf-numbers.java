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
    public int sumNumbers(TreeNode root) {
        int no = 0;
        totalSum = totalSum+fun(root,no);
        return totalSum;
    }
    int totalSum = 0;
    int fun(TreeNode root, int no) {
    if(root == null) {
        return 0;
    }
    no = no * 10 + root.val;
    if(root.left == null && root.right == null) {
        return no;
    }
    return fun(root.left, no) + fun(root.right, no);
}
}