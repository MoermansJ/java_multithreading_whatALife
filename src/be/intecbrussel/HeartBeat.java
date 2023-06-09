package be.intecbrussel;

public class HeartBeat extends Person implements Runnable {
    //properties
    private int milliSecondsBetweenBeats;


    //constructors
    public HeartBeat(int milliSecondsBetweenBeats) {
        this.milliSecondsBetweenBeats = milliSecondsBetweenBeats;
    }


    //custom methods
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("__/\\_/\\__");
                Thread.sleep(milliSecondsBetweenBeats);
            } catch (InterruptedException e) {
                System.out.println("Check run() in HeartBeat");
                e.printStackTrace();
//                break;
            }
        }
    }
}
