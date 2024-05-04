package com.practice.dsa.tree.visitor.pattern;

class FancyVisitor extends TreeVis {

    private int sumNonLeafNodesAtEvenDepth = 0;
    private int sumGreenLeafNodes = 0;

    public int getResult() {
        return Math.abs(sumNonLeafNodesAtEvenDepth - sumGreenLeafNodes);
    }

    public void visitNode(TreeNode node) {
        int depth = node.getDepth();
        if(depth % 2 == 0) {
            sumNonLeafNodesAtEvenDepth = sumNonLeafNodesAtEvenDepth + node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.GREEN) {
            sumGreenLeafNodes = sumGreenLeafNodes + leaf.getValue();
        }
    }
}
