package com.practice.dsa.tree.visitor.pattern;

class ProductOfRedNodesVisitor extends TreeVis {

    private long product = 1;
    private final long modulo = 1000000007;

    public int getResult() {
        return (int)product;
    }

    public void visitNode(TreeNode node) {
        Color color = node.getColor();
        if(color == Color.RED) {
            int value = node.getValue();
            if(value > 0) {
                product = (product*value) % modulo;
            } else {
                product = (product) % modulo;
            }
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        Color color = leaf.getColor();
        if(color == Color.RED) {
            int value = leaf.getValue();
            if(value > 0) {
                product = (product*value) % modulo;
            } else {
                product = (product) % modulo;
            }
        }
    }
}