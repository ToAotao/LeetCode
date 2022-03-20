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
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    public TreeNode build (int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode res = new TreeNode(max);
        
        res.left = build(nums, lo, idx - 1);

        res.right = build(nums, idx + 1, hi);
        return res;
    }
}