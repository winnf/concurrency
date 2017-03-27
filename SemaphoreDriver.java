import java.io.Console;
import java.util.*;

public class SemaphoreDriver {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("How many threads?: ");
        int numThreads = in.nextInt();
        System.out.println("How many semaphores? (Value must be less than # of threads): ");
        int numSem = in.nextInt();
        Thread myThreads[] = new Thread[numThreads];

        final Semaphore sem = new Semaphore(numSem);

        for (int i = 0; i < numSem-1; i++){
            myThreads[i] = new Thread(new SemaphoreThread(i, numSem, sem));
            myThreads[i].start();
        }
        for (int i = 0; i < numSem-1; i++){
            try {
                myThreads[i].join();
            } catch (InterruptedException ie) {} 
        }
    } 
}
