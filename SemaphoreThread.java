
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
            sem.P(); //similar to wait() since there is already a java wait() method
            System.out.println("Started thread: " + this.threadID);
            Thread.sleep(500);
            System.out.println("Exiting thread: " + this.threadID);
            sem.signal();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

