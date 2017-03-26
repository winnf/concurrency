import java.io.Console;

public class SemaphoreDriver {
    public static void main(String args[]){
        Thread myThreads[] = new Thread[5]; //initialized with 5 threads for now
        //int s = Integer.parseInt(str); //obtain # of semaphores from user input

        final Semaphore sem = new Semaphore(2);

        for (int i = 0; i < 4; i++){
            myThreads[i] = new Thread(new SemaphoreThread(i, 2, sem));
            myThreads[i].start();
        }
        for (int i = 0; i < 4; i++){
            try {
                myThreads[i].join();
            } catch (InterruptedException ie) {} 
        }
    } 
}
