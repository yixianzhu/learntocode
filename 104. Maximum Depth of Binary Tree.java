/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null? 0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        //remember to include "+1"!!!
    }
}
