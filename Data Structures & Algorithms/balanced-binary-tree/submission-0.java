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
    // Global answer variable
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        // base case
        if (root == null)
            return true;

        depth(root);

        return res;
    }

    public int depth(TreeNode root) {
        // base case to calculate height
        if (root == null)
            return 0;
        // If we ever get res = false, output is always false so no need to calculate further
        if (res == false)
            return 0;

        // Get left subtree height
        int left = depth(root.left);
        // Get right subtree height
        int right = depth(root.right);
        // Verify height difference between left and right
        if (Math.abs(left - right) <= 1) {
            res = res && true;
        } else
            res = false;
        // return height
        return 1 + Math.max(left, right);
    }
}
