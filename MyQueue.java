import java.util.LinkedList;

public class MyQueue {
    private int items;
    private int queueSize; 
    private LinkedList<Integer> q;

    public MyQueue(int queueSize){
        q = new LinkedList<Integer>();
        items = 0;
        int size = queueSize; 
    }

    public void removeFromQ(){
        items--;
        q.remove();
    }
    
    public void addToQ(int item){
        q.add(item);
        items++;
    }
}
