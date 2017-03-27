public class Semaphore {
    public int value;
    private int waiting; 

    public Semaphore(int v){
        value = v;
        waiting = 0; 
    }

    public synchronized void P(){ //lock
        if (value > 0){
            value --; 
        }
        else {
            try {
                waiting++;
                wait();
            }
            catch (InterruptedException e) {}
        }

    }

    public synchronized void signal(){ //unlock
        if (waiting > 0){
            notify();
            waiting--;
        }
        else {
            value++;
        }
    }
}
