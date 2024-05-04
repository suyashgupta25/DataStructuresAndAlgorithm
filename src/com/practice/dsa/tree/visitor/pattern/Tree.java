package com.practice.dsa.tree.visitor.pattern;

abstract class Tree {

    private final int value;
    private final Color color;
    private final int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

enum Color {
    RED, GREEN
}