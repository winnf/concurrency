import java.util.*;

public class MainDriver {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Queue size: ");
        int queueSize = in.nextInt();

        Semaphore empty = new Semaphore(queueSize);
        Semaphore mutex = new Semaphore(1);
        Semaphore full = new Semaphore(0);
        
        MyQueue queue = new MyQueue(queueSize);
        Thread p = new Thread(new Producer(queue, empty, mutex, full));
        Thread c = new Thread(new Consumer(queue, empty, mutex, full));

        p.start();
        c.start();
        try {
            p.join();
            c.join();
        } catch (InterruptedException ie) {} 
    }
}
