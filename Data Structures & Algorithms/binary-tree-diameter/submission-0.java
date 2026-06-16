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
    // Global variable to store the diameter as the recursion happens on the height
    // So we cant return the recursion output as our solution
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // Another way to track result can be by passing an array so that the
        // java call by value can be utilized to get back the answer later
        // int[] max = new int[1]; depth(root, max);
        depth(root);
        return max;
    }

    int depth(TreeNode root) {
        // Base case
        if (root == null)
            return 0;
        // Go to the furthest left node
        int left = depth(root.left);
        // Go to the furthest right node
        int right = depth(root.right);
        // Track the max diameter for the result
        max = Math.max(left + right, max);
        // Get the max depth of the tree
        return 1 + Math.max(left, right);
    }
}
