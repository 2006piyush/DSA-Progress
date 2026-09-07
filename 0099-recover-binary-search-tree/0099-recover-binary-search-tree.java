
class Solution {

    TreeNode prev = null;

    TreeNode g1 = null;
    TreeNode g2 = null;
    TreeNode g3 = null;
    TreeNode g4 = null;

    int g = 0;

    public void recoverTree(TreeNode root) {

        inorder(root);

        // Swap AFTER complete inorder traversal

        if (g == 1) {

            // Only one violation
            int temp = g1.val;
            g1.val = g2.val;
            g2.val = temp;

        } else if (g == 2) {

            // Two violations
            int temp = g1.val;
            g1.val = g4.val;
            g4.val = temp;
        }
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.val < prev.val) {

            if (g == 0) {

                // First violation
                g1 = prev;
                g2 = root;
                g++;

            } else if (g == 1) {

                // Second violation
                g3 = prev;
                g4 = root;
                g++;
            }
        }


        prev = root;

        inorder(root.right);
    }
}

