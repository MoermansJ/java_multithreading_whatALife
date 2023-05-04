package be.intecbrussel;

import java.util.Random;

public class Person implements Runnable {
    //properties
    private String name;
    private int age;
    private Thread heart;
    private Thread breathing;
    private Thread life;


    //constructors
    public Person() {
        this("a", 90, 5000);
    }

    public Person(String name, int age, int heartBeatMilliSeconds) {
        this.name = name;
        this.age = age;

        this.heart = new Thread(new HeartBeat(heartBeatMilliSeconds));
        this.breathing = new Thread(new Lungs());
        this.life = new Thread();
    }


    //getters & setters


    //custom methods
    public void startLife() {
        System.out.println("startlfie works");
        this.life.start();
        this.breathing.start();
        this.heart.start();
    }

    public void endLife() {
        this.breathing.interrupt();
        this.heart.interrupt();
        this.life.interrupt();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = this.age; i < 100; i++) {
            try {
                if (random.nextInt(21) == 13) {
                    break;
                }
                Thread.currentThread().wait(1000);
            } catch (InterruptedException e) {
                System.out.println("Check run() in Person");
            }
        }
        this.endLife();
    }
}
