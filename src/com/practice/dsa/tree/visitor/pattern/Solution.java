package com.practice.dsa.tree.visitor.pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    public static Tree solve() {
        File file = new File("file_inputs/demo_input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
        }

        Color[] colors = new Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt() == 1 ? Color.GREEN : Color.RED;
        }

        Map<Integer, Set<Integer>> nodeEdges = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (!nodeEdges.containsKey(u)) {
                nodeEdges.put(u, new HashSet<Integer>());
            }
            if (!nodeEdges.containsKey(v)) {
                nodeEdges.put(v, new HashSet<Integer>());
            }
            nodeEdges.get(u).add(v);
            nodeEdges.get(v).add(u);
        }

        Map<TreeNode, Integer> nodeIndexMap = new HashMap<>();
        List<TreeNode> parents = new ArrayList<>();

        TreeNode root = new TreeNode(vals[0], colors[0], 0);
        nodeIndexMap.put(root, 1);
        parents.add(root);

        while (!parents.isEmpty()) {
            List<TreeNode> nextLevelParents = new ArrayList<>();
            for (TreeNode node : parents) {
                int depth = node.getDepth();
                int parentIndex = nodeIndexMap.get(node);

                for (int childIndex : nodeEdges.get(parentIndex)) {
                    nodeEdges.get(childIndex).remove(parentIndex);
                    if (!nodeEdges.get(childIndex).isEmpty()) {
                        TreeNode child = new TreeNode(vals[childIndex - 1], colors[childIndex - 1], depth + 1);
                        nextLevelParents.add(child);
                        nodeIndexMap.put(child, childIndex);
                        node.addChild(child);
                    } else {
                        TreeLeaf leaf = new TreeLeaf(vals[childIndex - 1], colors[childIndex - 1], depth + 1);
                        node.addChild(leaf);
                    }
                }
            }
            parents = nextLevelParents;
        }
        sc.close();
        return root;
    }

    public static Tree solve2() {
        File file = new File("visitor_pattern_input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        Map<Integer, Integer> values = new HashMap<>();
        String valuesStr = scanner.nextLine();
        String[] strings = valuesStr.split(" ");
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(strings[i]);
            values.put(i+1, value);
        }

        Map<Integer, Color> colors = new HashMap<>();
        String colorsStr = scanner.nextLine();
        String[] colorsSplits = colorsStr.split(" ");
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(colorsSplits[i]);
            if(value == 0) {
                colors.put(i+1, Color.RED);
            } else {
                colors.put(i+1, Color.GREEN);
            }
        }

        for (int i = 0; i < count - 1; i++) {
            String posStr = scanner.nextLine();
            String[] posSplits = posStr.split(" ");
            int parent = Integer.parseInt(posSplits[0]);
            int child = Integer.parseInt(posSplits[1]);
            NodeOrLeaf nodeOrLeaf = new NodeOrLeaf(parent, child);
            nodeOrLeaves.add(nodeOrLeaf);
        }
        prepareIsLeafMap(count);
        Map<Integer, Tree> mapOfPoints = new HashMap<>();
        for (int i = 0; i < nodeOrLeaves.size(); i++) {
            NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
            int parentPos = nodeOrLeaf.parent;// 1
            int childPos = nodeOrLeaf.child;// 3

            Boolean isLeafParent = isLeaf.get(parentPos);
            Boolean isLeafChild = isLeaf.get(childPos);
            if(!isLeafParent && !isLeafChild) {
                Tree treeP = mapOfPoints.get(parentPos);
                Tree treeC = mapOfPoints.get(childPos);
                if(treeP == null) {
                    treeP = new TreeNode(values.get(parentPos), colors.get(parentPos), depthMap.get(parentPos));
                }
                if(treeC == null) {
                    treeC = new TreeNode(values.get(childPos), colors.get(childPos), depthMap.get(childPos));
                } else {
                    //treeC is in the map and it is a TreeNode already
                    // make treeP a child here
                    ((TreeNode)treeC).addChild(treeP);
                    mapOfPoints.put(parentPos, treeP);
                    mapOfPoints.put(childPos, treeC);
                    continue;
                }
                ((TreeNode)treeP).addChild(treeC);
                mapOfPoints.put(parentPos, treeP);
                mapOfPoints.put(childPos, treeC);
            } else if(isLeafParent && !isLeafChild) {
                Tree treeP = mapOfPoints.get(parentPos);
                Tree treeC = mapOfPoints.get(childPos);
                if(treeP == null) {
                    treeP = new TreeLeaf(values.get(parentPos), colors.get(parentPos), depthMap.get(parentPos));
                }
                if(treeC == null) {
                    treeC = new TreeNode(values.get(childPos), colors.get(childPos), depthMap.get(childPos));
                }
                ((TreeNode)treeC).addChild(treeP);
                mapOfPoints.put(parentPos, treeP);
                mapOfPoints.put(childPos, treeC);
            } else if(!isLeafParent) {
                Tree treeP = mapOfPoints.get(parentPos);
                Tree treeC = mapOfPoints.get(childPos);
                if(treeP == null) {
                    treeP = new TreeNode(values.get(parentPos), colors.get(parentPos), depthMap.get(parentPos));
                }
                if(treeC == null) {
                    treeC = new TreeLeaf(values.get(childPos), colors.get(childPos), depthMap.get(childPos));
                }
                ((TreeNode)treeP).addChild(treeC);
                mapOfPoints.put(parentPos, treeP);
                mapOfPoints.put(childPos, treeC);
            } else {
                System.err.println("Both cannot be leaf types");
            }
        }
        return mapOfPoints.get(1);
    }

    static List<NodeOrLeaf> nodeOrLeaves = new ArrayList<>();
    static Map<Integer, Boolean> isLeaf = new HashMap<>();
    static Map<Integer, Integer> depthMap = new HashMap<>();
    static void prepareIsLeafMap(int maxPos) {
        depthMap.put(1, 0);
        for (int j = 1; j <= maxPos; j++) {
            int edges = 0;
            for (int i = 0; i < nodeOrLeaves.size(); i++) {
                NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
                int parent = nodeOrLeaf.parent;
                int child = nodeOrLeaf.child;
                if(parent == j) {
                    ++edges;
                }
                if(child == j) {
                    ++edges;
                }
                if(depthMap.size() != maxPos) {
                    if(depthMap.containsKey(parent)) {
                        depthMap.put(child, 1+ depthMap.get(parent));
                    }
                    if(depthMap.containsKey(child) && !depthMap.containsKey(parent)) {
                        depthMap.put(parent, 1+ depthMap.get(child));
                    }
                }
            }

            if(edges == 1) {
                isLeaf.put(j, true);
            } else {
                isLeaf.put(j, false);
            }
        }
    }

    static class NodeOrLeaf {
        int parent;
        int child;

        public NodeOrLeaf(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
