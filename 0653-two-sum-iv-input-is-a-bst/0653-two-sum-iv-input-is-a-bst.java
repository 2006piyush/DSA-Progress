class Solution {
    public boolean findTarget(TreeNode root, int k) {

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        TreeNode left = getNext(leftStack);
        TreeNode right = getPrev(rightStack);

        while (left != right) {

            int sum = left.val + right.val;

            if (sum == k) {
                return true;
            }

            if (sum < k) {
                left = getNext(leftStack);
            } else {
                right = getPrev(rightStack);
            }
        }

        return false;
    }

    // Push path to smallest node
    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    // Push path to largest node
    private void pushRight(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
    }

    // Get next smallest
    private TreeNode getNext(Stack<TreeNode> stack) {

        TreeNode node = stack.pop();

        if (node.right != null) {
            pushLeft(node.right, stack);
        }

        return node;
    }

    // Get next largest
    private TreeNode getPrev(Stack<TreeNode> stack) {

        TreeNode node = stack.pop();

        if (node.left != null) {
            pushRight(node.left, stack);
        }

        return node;
    }
}