/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    boolean pFound = false;
    boolean qFound = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }
    
    private TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = recur(root.left, p, q);
        TreeNode right = recur(root.right, p, q);
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        
        if (left != null && right != null) {
            return root;
        }
        
        return left == null ? right : left;
    }
}
