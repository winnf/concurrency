import java.util.*;

public class Producer implements Runnable {
    private MyQueue q;
    private Semaphore empty;
    private Semaphore mutex;
    private Semaphore full;

    public Producer(MyQueue q, Semaphore e, Semaphore m, Semaphore f){
        this.q = q;
        this.empty = e;
        this.mutex = m;
        this.full = f;
    }
     
    public void run(){
        for (int i=0; i < 10; i++){
            this.empty.P();
            this.mutex.P();
            q.addToQ(i);
            System.out.println("The producer thread added: " + i);
            this.mutex.signal();
            this.full.signal();
        }
    }
}


