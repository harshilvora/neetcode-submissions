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
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return ans;

        ans = kthSmallest(root.left, k);
        count++;
        if (count == k) {
            return root.val;
        }
        ans = kthSmallest(root.right, k);
        return ans;
    }
}
