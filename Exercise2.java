import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise2 {

    static AtomicBoolean ready = new AtomicBoolean(false);

    public static void main(String args[]) {
        Thread myThreads[] = new Thread[10];
        int num = 5345;
        int start = 2;
        int end = start + (num-2)/10;

        for (int i = 0; i < 10; i++){
            myThreads[i] = new Thread(new DivisionThreads(i, num, start, end, ready));
            myThreads[i].start();
            start = end;
            end = start + (num-2)/10;
        }

        System.out.println("READY");
        ready.set(true); //wait until all threads are ready before running
        for (int i = 0; i < 10; i++){
            try {
                myThreads[i].join();
            } catch (InterruptedException ie) {}
        }

        if(DivisionThreads.isPrime == true)
        {
          System.out.println(num + " is a prime number");
        }
        else{
          System.out.println(num + " is not a prime number");
        }
    }
}
