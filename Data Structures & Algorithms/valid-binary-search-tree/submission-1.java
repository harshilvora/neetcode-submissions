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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        // Constraint in Question
        return dfs(root, -10000, 10000);
    }

    public boolean dfs(TreeNode node, int left, int right) {
        // If reach end then true
        if (node == null)
            return true;
        // If not left < node.val < right then false
        if (node.val <= left || node.val >= right)
            return false;
        // If tree goes left then the max value for the next node is the current value
        // If tree goes right then the min value for the next node is the current value
        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }
}
