//java thread creation

import java.util.concurrent.atomic.AtomicBoolean;

public class RunnableThread implements Runnable {
    private int threadID;
    private int potentialPrime;
    private Prime isPrime; 
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
        System.out.println("Hello from a thread!" + this.threadID);
        double half = this.potentialPrime / 2;
        boolean flag = true;

        for (int i = 2; i <= half; i++){
            if (this.potentialPrime % i == 0){
                flag = false;
                break;
            }
        }
        if(flag == true){
            System.out.println("The number is prime");
        }
    }
}
