package com.practice.java;

class Food {
}

class DogFood extends Food {
}

class Animal {

    protected Food seekFood() {
        return new Food();
    }
}
// Dog class
class Dog extends Animal {
    @Override
    protected Food seekFood() {

        return new DogFood();
    }
}

//It’s possible to modify the return type of the Dog’s seekFood() method to DogFood - a subclass of Food: Try it!