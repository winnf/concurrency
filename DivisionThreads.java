//java thread creation

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DivisionThreads implements Runnable {
    private int threadID;
    private int targetNumber;
    private int start;
    private int end;
    private AtomicBoolean ready;
    public static Boolean isPrime = true;
    private ReentrantLock lock = new ReentrantLock();

    public DivisionThreads(int threadID, int targetNumber, int start, int end, AtomicBoolean ready){
        this.threadID = threadID;
        this.targetNumber = targetNumber;
        this.start = start;
        this.end = end;
        this.ready = ready;
    }
    public void run() {
        while (!ready.get()){
            Thread.yield(); //only run when atomic boolean is true
        }

        for(int i = this.start; i<= this.end; i++)
        {
          if(this.targetNumber % i == 0){
            isPrime = false;
            lock.lock();
            System.out.println(i + " divides " + this.targetNumber);
            lock.unlock();
          }
        }
        lock.lock();
        System.out.println("Thread "+ this.threadID + " is done");
        lock.unlock();
    }
}
