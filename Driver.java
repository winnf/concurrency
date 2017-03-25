import java.util.concurrent.atomic.AtomicBoolean;

public class Driver {
    public static void main(String args[]) {
        Thread myThreads[] = new Thread[300];
        AtomicBoolean ready = new AtomicBoolean(); //set atomic boolean to false
        int num = 654323;

        for (int i = 0; i < 299; i++){
            myThreads[i] = new Thread(new RunnableThread(i, num));
            myThreads[i].start();
            ready.set(true); //wait until all threads are ready before running
        }
        for (int i = 0; i < 299; i++){
            try {
                myThreads[i].join();
            } catch (InterruptedException ie) {} 
        }
    }
}
