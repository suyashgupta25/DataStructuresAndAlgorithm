package com.practice.ibm;

import java.util.ArrayList;
import java.util.List;

/*
Given a tree with n nodes, rooted at node 0 (nodes are numbered from 0 to n-1),  with values assigned to nodes  such
that values[i] denotes the value of node i, find the maximum sum of the values along any path starting at some node u
and going only down the tree. In other words, only consider paths u1, u2, u3,..., uk where each node  is a child of
node ui-1 for 1<i<=k

https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
https://leetcode.com/discuss/interview-question/422728/startup-online-assessment-maximum-path-in-graphtree

Not correct: https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
*/
public class SumOfNodesDownInTree {

    static int res = Integer.MIN_VALUE;
    private static int maxSum = Integer.MIN_VALUE;

    static class TreeNode {
        int val;
        List<TreeNode> children;

        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        maxSum = Integer.MIN_VALUE;

        dfs(root);

        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        int maxChildSum = 0;

        for (TreeNode child : node.children) {
            maxChildSum = Math.max(maxChildSum, dfs(child));
        }

        int currentMaxSum = node.val + maxChildSum;
        maxSum = Math.max(maxSum, currentMaxSum);

        return currentMaxSum;
    }

    public static TreeNode buildTree(int[] parents, int[] values) {
        int n = parents.length;
        TreeNode[] nodes = new TreeNode[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(values[i]);
        }

        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                root = nodes[i];
            } else {
                nodes[parents[i]].children.add(nodes[i]);
            }
        }
        return root;
    }

    public static int bestSumDownwardTreePath(List<Integer> parent, List<Integer> values) {
        // We need arrays moving forward, so converting them
        int[] parentArray = parent.stream().mapToInt(i -> i).toArray();
        int[] valuesArray = values.stream().mapToInt(i -> i).toArray();
        TreeNode root = buildTree(parentArray, valuesArray);
        return maxPathSum(root);
    }

    public static void main(String[] args) {
        // Example usage:
        int[] parents = {-1, 0, 0, 1, 1};
        int[] values = {1, 2, 3, 4, 5};

        TreeNode root = buildTree(parents, values);
        System.out.println("Max Path Sum: " + maxPathSum(root));  // Output should be 8 (1 -> 2 -> 5)
    }
}


/*
    Explanation:
    TreeNode Class:

    Represents each node in the tree with a value (val) and a list of children (children).
    maxPathSum Method:

    Takes the root of the tree as input and initializes the global maxSum variable.
    Calls the dfs method to perform a depth-first search on the tree starting from the root.
    dfs Method:

    Recursively computes the maximum path sum starting from the given node.
    For each node, it computes the maximum path sum for all its children and adds the node's value to it.
    Updates the global maxSum variable with the maximum path sum found.
    buildTree Method:

    Constructs the tree from the parents and values arrays.
    Creates an array of TreeNode objects and links them according to the parents array.
    Identifies the root node (where parents[i] == -1).
    Main Method:

    Creates an example tree using the parents and values arrays and calls the maxPathSum method to find the maximum path sum.
            Example:
    In the example provided, the tree is constructed as follows based on parents array:

    markdown
    Copy code
                0
                / \
                1   2
                / \
                3   4
    The values of the nodes are [1, 2, 3, 4, 5], and the maximum path sum is found to be 12 (path: 0 -> 1 -> 4).

    This approach ensures that the tree is correctly built from the parent-child relationships and then efficiently computes the maximum path sum using a DFS traversal.

*/
