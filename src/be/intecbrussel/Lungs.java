package be.intecbrussel;

public class Lungs extends Person implements Runnable {
    //properties
    private boolean lungsFull;


    //constructors
    public Lungs() {

    }

    //custom methods
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(lungsFull ? "Breathe out" : "Breathe in");
                lungsFull = !lungsFull;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Check run() in Lungs");
                e.printStackTrace();
//                break;
            }
        }
    }
}
