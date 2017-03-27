import junit.framework.*;
import java.util.*;
import org.junit.*;

public class QueueTest extends TestCase {
   
    protected void setUp(){
        MyQueue queue = new MyQueue(5);
        MyQueue queue2 = new MyQueue(0);
        MyQueue queue3 = new MyQueue(1000);
    }

   @Test
   //uses black box with boundary-value analysis
   //use 0, 5, 1000
  public void testAddtoQueue(){
      int value = 1;
      queue.addToQ(value);
      assertTrue(!queue.isEmpty());
  }

  public void testAddtoQ2(){
      int value = 1;
      queue.addToQ(value);
      assertTrue(queue.isEmpty());
  }

  @Test
  public void testRemoveFromQ(){
      queue.addToQ(1);
      assertTrue(1 == queue.removeFromQ());
  }

  @Test
  public void testOrder(){
      queue3.addToQ(1);
      queue3.addToQ(2);
      queue3.addToQ(3);
      assertEquals(1, queue3.removeFromQ());
      assertEquals(2, queue3.removeFromQ());
      assertEquals(3, queue3.removeFromQ());
  }

  @Test
  //uses white box testing: statement coverage, branch coverage, condition coverage, path coverage
  public void testRemove(){
      answer = queue.removeFromQ();
  }
}

