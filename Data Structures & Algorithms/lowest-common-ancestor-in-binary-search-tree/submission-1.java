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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;

        while (ans != null) {
            // In BST if p & q is less than root value then it will be on the left of the current
            // node
            if (p.val > ans.val && q.val > ans.val) {
                ans = ans.right;
            }
            // In BST if p & q is greater than root value then it will be on the left of the current
            // node
            else if (p.val < ans.val && q.val < ans.val) {
                ans = ans.left;
            }
            // If p and q between the current value then this will be the LCA
            else {
                return ans;
            }
        }
        return null;
    }
}
