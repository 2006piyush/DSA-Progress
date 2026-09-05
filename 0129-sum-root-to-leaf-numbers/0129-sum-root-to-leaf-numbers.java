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
    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        fun(root, 0);
        return totalSum;
    }

    void fun(TreeNode root, int no) {

        if (root == null) {
            return;
        }

        no = no * 10 + root.val;

        // We reached a leaf
        if (root.left == null && root.right == null) {
            totalSum = totalSum + no;
            return;
        }

        fun(root.left, no);
        fun(root.right, no);
    }
}