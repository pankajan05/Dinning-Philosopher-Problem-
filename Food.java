package com.company;

public class Food {
    private int food;

    public Food(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food -= food;
    }
}
