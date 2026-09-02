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

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            fun(root, p, q);
        } else {
            fun(root, q, p);
        }

        return ans;
    }

    TreeNode fun(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val < p.val) {
            return fun(root.right, p, q);
        }

        else if (root.val > q.val) {
            return fun(root.left, p, q);
        }

        ans = root;
        return ans;
    }
}