import junit.framework.TestCase;
import java.util.*;

public class TaskManagerTest extends junit.framework.TestCase {
    private UserService userServ;

    public String testAddUserTask(n, r, e, a){
        //userServ adds a user to a task, associates with DB
        //responds by return the name of the user
        name = userServ.addUserToTask(n, r, e, a);
        assertEquals("Tammy Tester", name);
    } 

    public String testAddUserTaskFail(n, r, e, a){
        name = userServ.addUserToTask("Not Tammy", r, e, a);
        assertEquals(
    }

}


