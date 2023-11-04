// 102. Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        writeLevelMap(0, root, result);
        return result;
    }

    private void writeLevelMap(int level, TreeNode node, List<List<Integer>> result) {
        if (node == null) return;

        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        
        writeLevelMap(level + 1, node.left, result);
        writeLevelMap(level + 1, node.right, result);
    }
}
