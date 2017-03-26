import java.util.concurrent.Semaphore;

public class SemaphoreThread implements Runnable {
    private int threadID;
    private int capacity;
    private Semaphore sem;

    public SemaphoreThread(int threadID, int capacity, Semaphore sem){
        this.threadID = threadID;
        this.capacity = capacity;
        this.sem = sem;
    }
    public void run() {
        try {
            sem.acquire(); //similar to wait()
            System.out.println("Started thread: " + this.threadID);
            Thread.sleep(500);
            System.out.println("Exiting thread: " + this.threadID);
            sem.release(); //similar to signal()
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

