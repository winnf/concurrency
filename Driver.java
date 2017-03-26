import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Driver {

    static AtomicBoolean ready = new AtomicBoolean(false);
    static int winner = 0;

    synchronized static void done(int id){
        if (winner == 0) {
            winner = id;
        }
    }

    public static void main(String args[]) {
        Thread myThreads[] = new Thread[300];
        int num = 654323;

        for (int i = 0; i < 299; i++){
            myThreads[i] = new Thread(new RunnableThread(i, num, ready));
            myThreads[i].start();
        }
        
        System.out.println("READY");
        ready.set(true); //wait until all threads are ready before running
        for (int i = 0; i < 299; i++){
            try {
                myThreads[i].join();
            } catch (InterruptedException ie) {} 
        }
        System.out.println("Thread #" + winner + " finished first! 654323 is a prime number");
    }
}
