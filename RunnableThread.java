//java thread creation

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableThread implements Runnable {
    private int threadID;
    private int potentialPrime;
    private AtomicBoolean ready;

    public RunnableThread(int threadID, int potentialPrime, AtomicBoolean ready){
        this.threadID = threadID;
        this.potentialPrime = potentialPrime;
        this.ready = ready;
    }
    public void run() {
        while (!ready.get()){
            Thread.yield(); //only run when atomic boolean is true
        }
        double half = this.potentialPrime / 2;
        boolean flag = true;

        for (int i = 2; i <= half; i++){
            if (this.potentialPrime % i == 0){
                flag = false;
                break;
            }
        }
        if(flag == true){
            Driver.done(this.threadID);
        }
    }
}
