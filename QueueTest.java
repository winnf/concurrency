import junit.framework.TestCase;
import java.util.*;

public class QueueTest extends TestCase {
    protected void setUp(){
        queue = new Queue(5);
        queue2 = new Queue(1);
        queue3 = new Queue(1000);
    }

   //uses black box with boundary-value analysis
   //below the range: removing when it's already empty
   //within the range: adding/removing one from the queue 
   //above the range: adding when queue is full


  //within the range
  public void testAddtoQueue(){
      String lab_member_name = "Winnie Fong";
      queue.enqueue(lab_member_name);
      assertTrue(!queue.isEmpty());
  }

  //above the range
  public void testFull(){
      String lab_member_name = "Winnie Fong";
      String lab_member_name2 = "Anna Dong";
      queue2.enqueuevalue(lab_member_name);
      assertTrue("Sorry, the queue is full", !queue2.enqueue(lab_member_name2);
  }

  //within the range
  public void testRemoveFromQ(){
      String lab_member_name = "Winnie Fong";
      queue.enqueue(lab_member_name);
      assertTrue("Winnie Fong" == queue.dequeue());
  }

  //below the range
  public void testEmpty(){
      String member_name1 = "Anna Dong";
      String member_name2 = "Winnie Fong";
      queue.enqueue(member_name1);
      queue.enqueue(member_name2);
      queue.dequeue();
      queue.dequeue();
      assertTrue("Queue is empty", queue.dequeue());
  }

  //within the range
  public void testOrder(){
      queue3.enqueue(1);
      queue3.enqueue(2);
      queue3.enqueue(3);
      assertEquals(1, queue3.dequeue());
      assertEquals(2, queue3.dequeue());
      assertEquals(3, queue3.dequeue());
  }

  //test with larger queue within the range
  public void testAddtoQueue3(){
      for(i=0; i<999; i++){
          assertTrue("Successfully imported lab_members", queue.enqueue(i));
      }
  }

  //uses white box testing: statement coverage, branch coverage, condition coverage, path coverage
}

