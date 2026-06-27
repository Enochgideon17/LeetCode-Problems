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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case
        if (root == null) {
            return false;
        }

        // If this is a leaf node, check sum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recurse on left and right
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}

