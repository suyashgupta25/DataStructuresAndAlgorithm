package com.practice.java;

interface BaseI {
    void sameNameMethod();
}

class BaseC {
    public void sameNameMethod() {
        System.out.println("IC");
    }
}

class ImpC extends BaseC implements BaseI {
    public static void main(String[] args) {
        (new ImC2()).sameNameMethod();
        (new ImpC()).sameNameMethod();
    }
}

class ImC2 implements BaseI {
    public static void main(String[] args) {
        (new ImC2()).sameNameMethod();
        (new ImpC()).sameNameMethod();
    }

    // YOU HAVE TO OVERRIDE: THERE IS NO OPTION
    @Override
    public void sameNameMethod() {
        System.out.println("IC2");
    }
}

