package longjump;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Track {

    private Random rnd = new Random();
    private static final int STEP = 40;
    private static final int MAX_LENGTH = 440;
    private int points;
    Lock lock = new ReentrantLock();

    public void jump(String name) {
        int length = rnd.nextInt(MAX_LENGTH);
        points = 0;
        lock.lock();
        System.out.print(name + " ");
        for (int i = 0; i < length; i += STEP) {
            System.out.print("-");
        }
        points = length / STEP;
        System.out.printf("| %s points%n",points); 
    }

    public void startNextGamer() {
        lock.unlock();
        try {
            synchronized (this) {
                notify();
                wait(500L);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    int getPoints() {
        return points;
    }
}
