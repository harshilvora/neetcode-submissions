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
    public int goodNodes(TreeNode root) {
        return checkVal(root, root.val);
    }

    int checkVal(TreeNode node, int max) {
        if (node == null)
            return 0;
        //Check if current value is greater than max till now. If it is then its a good node.
        int res = (node.val >= max) ? 1 : 0;
        max = Math.max(node.val, max);
        //Traverse the tree
        res += checkVal(node.left, max) + checkVal(node.right, max);
        return res;
    }
}
