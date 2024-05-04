package com.practice.dsa.tree.visitor.pattern;

class SumInLeavesVisitor extends TreeVis {

    private int sumOfLeaves = 0;

    public int getResult() {
        return sumOfLeaves;
    }

    public void visitNode(TreeNode node) {

    }

    public void visitLeaf(TreeLeaf leaf) {
        sumOfLeaves = sumOfLeaves + leaf.getValue();
    }
}
