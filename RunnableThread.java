//java thread creation
class Prime
{
    private boolean isPrime;

    public boolean getIsPrime(){
        return isPrime;
    }
    public void setIsPrime(boolean isPrime){
        this.isPrime = isPrime;
    }
}

public class RunnableThread implements Runnable {
    private int threadID;
    private int potentialPrime;
    private Prime isPrime; 

    public RunnableThread(int threadID, int potentialPrime){
        this.threadID = threadID;
        this.potentialPrime = potentialPrime;
    }
    public void run() {
        Thread.yield();
        System.out.println("Hello from a thread!" + this.threadID);
        if (this.potentialPrime % 2 == 0){
            isPrime.setIsPrime(false);
        }
        double sqroot = Math.sqrt(this.potentialPrime);
        for(int i = 3; i < sqroot; i += 2){
            if (this.potentialPrime % i == 0){
                isPrime.setIsPrime(false);
            }
        }
        isPrime.setIsPrime(true);
    }
}
