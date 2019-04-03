package com.company;

public class Main {

    public static void main(String[] args) {
        int number = 5;
        //create the object holders
        Philosopher philosophers[] = new Philosopher[number];
        Fork forks[] = new Fork[number];


        for(int c = 0; c<number; c++)
        {
            forks[c] = new Fork(c);
        }


        for (int i = 0; i < number; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % number];

            if (i == number - 1) {

                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork, 200);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork, 200);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }


    }
}
