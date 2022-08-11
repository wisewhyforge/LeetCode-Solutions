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
        ArrayList<Integer> ans = new ArrayList<Integer>();
        isValidBSTRecur(root, ans);
        int prev = ans.get(0);
        for(int i = 1; i < ans.size(); i++) {
            
            if(prev >= ans.get(i)) {
                return false;
            }
            prev = ans.get(i);
        }
        return true;
    }
    
    public void isValidBSTRecur(TreeNode root, ArrayList<Integer> numbers) {
        if(root == null) return;
        isValidBSTRecur(root.left, numbers);
        numbers.add(root.val);
        isValidBSTRecur(root.right, numbers);
    }
}
