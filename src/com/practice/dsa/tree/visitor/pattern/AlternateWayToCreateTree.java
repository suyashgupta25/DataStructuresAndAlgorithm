package com.practice.dsa.tree.visitor.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlternateWayToCreateTree {
    static List<Solution.NodeOrLeaf> nodeOrLeaves = new ArrayList<>();
    static boolean isLeaf(int pos) {
        for (int i = 0; i < nodeOrLeaves.size(); i++) {
            Solution.NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
            if(nodeOrLeaf.parent == pos) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        List<Color> colors = new ArrayList<>();

        Map<Integer, Tree> mapParent = new HashMap<>();
        Tree nodeOne = new TreeNode(values.get(0), colors.get(0), 0);
        for (int i = 0; i < nodeOrLeaves.size(); i++) {
            Solution.NodeOrLeaf nodeOrLeaf = nodeOrLeaves.get(i);
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
    }
}
