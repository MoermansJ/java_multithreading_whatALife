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
    }

    public Person(String name, int age, int heartBeatMilliSeconds) {
        this.name = name;
        this.age = age;

        this.life = new Thread(this);
        this.heart = new Thread(new HeartBeat(heartBeatMilliSeconds));
        this.breathing = new Thread(new Lungs());
    }


    //custom methods
    public void startLife() {
        this.life.start();
        this.heart.start();
        this.breathing.start();
    }

    public void endLife() {
        this.life.interrupt();
        this.heart.interrupt();
        this.breathing.interrupt();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = this.age; i < 100; i++) {
            try {
                int myran = random.nextInt(21);
                System.out.println(myran);
                if (myran == 13) {
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Check run() in Person");
            }
        }
        this.endLife();
    }
}
