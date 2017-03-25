import java.util.concurrent.atomic.AtomicBoolean;

public class Driver {

    static AtomicBoolean ready = new AtomicBoolean(false);

    public static void main(String args[]) {
        Thread myThreads[] = new Thread[300];
        Prime primeObj = new Prime();
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
    }
}
