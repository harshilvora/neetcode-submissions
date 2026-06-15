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
    public int maxDepth(TreeNode root) {
        //Base case if reached null then return 0
        if(root == null)
            return 0;

        //Compute depth of left and right subtree and keep the max of either side to get the maximum level
        //Added 1 for the root or the current node in the count
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
