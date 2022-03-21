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
// 9 3 15 20 7
//   r
// l     r
// 9 15 7 20 3
// l  r      r
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int idx = 0;
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal ) {
                idx = i;
                break;
            }
        }
        int leftSize = idx - inStart;
        root.left = build(inorder, inStart, idx - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, idx + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}