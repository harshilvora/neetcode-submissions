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

    //Java record class to track the height for each node
    public record NodeHeight(TreeNode node, int height) {}

    // Iterative DFS
    public int maxDepth(TreeNode root) {
        
        if (root == null)
            return 0;
        int max = 0;
        ArrayDeque<NodeHeight> st = new ArrayDeque<>();
        // Base case root is at 1 height
        st.push(new NodeHeight(root, 1));

        while (!st.isEmpty()) {
            NodeHeight p = st.pop();
            TreeNode node = p.node();
            int h = p.height();
            //For each node add the height by 1
            if (node.left != null) {
                st.push(new NodeHeight(node.left, h + 1));
            }
            if (node.right != null) {
                st.push(new NodeHeight(node.right, h + 1));
            }
            //Track the max depth vs current height
            max = Math.max(h, max);
        }
        return max;
    }
}
