// 230. Kth Smallest Element in a BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                
                if (--k == 0) return cur.val;

                cur = cur.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }

        return -1;
    }
}
