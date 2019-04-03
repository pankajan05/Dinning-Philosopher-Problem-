package com.company;

public class Philosopher implements Runnable{
    //The forks that use by philosophers
    private Fork leftFork,rightFork;
    private Food food=null;
    private int amount;

    public Philosopher(Fork leftFork, Fork rightFork, int food) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.food = new Food(food);
    }

    //do the action that eating or thinking
    private void perform(String action){
        System.out.printf("%s %s\n",Thread.currentThread().getName(),action);
        amount = ((int) (Math.random() * 100));
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while(food.getFood() > 0){
            //start from philosophers thinking
            perform("Thinking");

                synchronized (leftFork) {
                    perform(" Picked up left fork "+leftFork.getNo());
                    synchronized (rightFork) {
                        // eating
                        perform("Picked up right fork "+rightFork.getNo()+" - eating");
                        food.setFood(amount);
                        perform("eat:"+amount+" .balance:"+food.getFood()+" . Put down right fork "+rightFork.getNo());
                    }

                    // Back to thinking
                    perform(" Put down left fork. Back to thinking");
                }
        }

    }
}
