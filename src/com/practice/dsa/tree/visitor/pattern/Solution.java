package com.practice.dsa.tree.visitor.pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    public static Tree solve() {
        File file = new File("file_input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<Integer> values = new ArrayList<>();
        String valuesStr = scanner.nextLine();
        String[] strings = valuesStr.split(" ");
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(strings[i]);
            values.add(value);
        }

        List<Color> colors = new ArrayList<>();
        String colorsStr = scanner.nextLine();
        String[] colorsSplits = colorsStr.split(" ");
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(colorsSplits[i]);
            if(value == 0) {
                colors.add(Color.RED);
            } else {
                colors.add(Color.GREEN);
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
        Map<Integer, Tree> mapParent = new HashMap<>();
        Tree nodeOne = new TreeNode(values.get(0), colors.get(0), 0);
        mapParent.put(1, nodeOne);
        for (int i = 0; i < nodeOrLeaves.size(); i++) {
            NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
            int parentPos = nodeOrLeaf.parent;// 1
            int childPos = nodeOrLeaf.child;// 3

            int parentIndex = nodeOrLeaf.parent - 1;// 0
            int childIndex = nodeOrLeaf.child - 1;// 2

            if(mapParent.containsKey(parentPos)) {
                TreeNode nodeParent = (TreeNode) mapParent.get(parentPos);
                if(isLeaf(childPos)) {
                    Tree childLeaf = new TreeLeaf(values.get(childIndex), colors.get(childIndex), -1);
                    nodeParent.addChild(childLeaf);
                } else {
                    Tree childNode = new TreeNode(values.get(childIndex), colors.get(childIndex), -1);
                    nodeParent.addChild(childNode);
                    mapParent.put(childPos, childNode);
                }
            } else {
                TreeNode nodeNotExist = new TreeNode(values.get(parentIndex), colors.get(parentIndex), 0);
                if(isLeaf(childPos)) {
                    Tree childLeaf = new TreeLeaf(values.get(childIndex), colors.get(childIndex), -1);
                    nodeNotExist.addChild(childLeaf);
                } else {
                    Tree childNode = new TreeNode(values.get(childIndex), colors.get(childIndex), -1);
                    nodeNotExist.addChild(childNode);
                    mapParent.put(childPos, childNode);
                }
                mapParent.put(parentPos, nodeNotExist);
            }
        }
        return nodeOne;
    }

    static List<NodeOrLeaf> nodeOrLeaves = new ArrayList<>();
    static boolean isLeaf(int pos) {
        for (int i = 0; i < nodeOrLeaves.size(); i++) {
            NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
            if(nodeOrLeaf.parent == pos) {
                return false;
            }
        }
        return true;
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
