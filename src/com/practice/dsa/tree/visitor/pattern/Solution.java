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
        prepareIsLeafMap(count);
        Map<Integer, Tree> mapOfPoints = new HashMap<>();
        for (int i = 0; i < nodeOrLeaves.size(); i++) {
            NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
            int parentPos = nodeOrLeaf.parent;// 1
            int childPos = nodeOrLeaf.child;// 3

            int parentIndex = nodeOrLeaf.parent - 1;// 0
            int childIndex = nodeOrLeaf.child - 1;// 2

            Boolean isLeafParent = isLeaf.get(parentPos);

            TreeNode treeParent = null;
            if(!mapOfPoints.containsKey(parentPos)) {
                treeParent = new TreeNode(values.get(parentIndex), colors.get(parentIndex), 0);
                mapOfPoints.put(parentPos, treeParent);
            }
            treeParent = (TreeNode) mapOfPoints.get(parentPos);
            if(mapOfPoints.containsKey(childPos)) {
                Tree treeChild = mapOfPoints.get(childPos);
                treeParent.addChild(treeChild);
            } else {
                if(isLeaf.get(childPos)) {
                    Tree childLeaf = new TreeLeaf(values.get(childIndex), colors.get(childIndex), -1);
                    treeParent.addChild(childLeaf);
                    mapOfPoints.put(childPos, childLeaf);
                } else {
                    Tree childNode = new TreeNode(values.get(childIndex), colors.get(childIndex), -1);
                    treeParent.addChild(childNode);
                    mapOfPoints.put(childPos, childNode);
                }
            }
        }
        Integer sum = 0;
        for (Map.Entry<Integer, Tree> entry : mapOfPoints.entrySet()) {
            if(entry.getValue() instanceof TreeLeaf) {
                sum = sum + entry.getValue().getValue();
            }
        }
        return mapOfPoints.get(1);
    }

    static List<NodeOrLeaf> nodeOrLeaves = new ArrayList<>();
    static Map<Integer, Boolean> isLeaf = new HashMap<>();
    static void prepareIsLeafMap(int maxPos) {
        for (int j = 1; j < maxPos; j++) {
            int edges = 0;
            for (int i = 0; i < nodeOrLeaves.size(); i++) {
                NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
                if(nodeOrLeaf.parent == j) {
                    ++edges;
                }
                if(nodeOrLeaf.child == j) {
                    ++edges;
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
