package com.practice.dsa.tree.visitor.pattern;

class ProductOfRedNodesVisitor extends TreeVis {

    private int product = 1;

    public int getResult() {
        return product;
    }

    public void visitNode(TreeNode node) {
        Color color = node.getColor();
        if(color == Color.RED) {
            int value = node.getValue();
            if(value != 0) {
                product = product * value;
            }
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        Color color = leaf.getColor();
        if(color == Color.RED) {
            int value = leaf.getValue();
            if(value != 0) {
                product = product * value;
            }
        }
    }
}