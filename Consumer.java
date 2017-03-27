import java.util.*;

public class Consumer implements Runnable {
    private MyQueue q;
    private Semaphore empty;
    private Semaphore mutex;
    private Semaphore full;

    public Consumer(MyQueue q, Semaphore e, Semaphore m, Semaphore f){
        this.q = q;
        this.empty = e;
        this.mutex = m;
        this.full = f;
    }
     
    public void run(){
        for (int i=0; i < 10; i++){
            //System.out.println("full value: " + this.full.value);
            //System.out.println("mutex value: " + this.mutex.value);
            this.full.P();
            this.mutex.P();
            q.removeFromQ();
            System.out.println("The consumer thread removed item: " + i);
            this.mutex.signal();
            this.empty.signal();
        }
    }
}

