import junit.framework.TestCase;
import java.util.*;

//driver reponsible of passing test cases to other pieces of code
public class TaskDriver {
    public static void main(String[] args){
        taskManager = new TaskManagerTest();
        user = new UserStubbed();
        task = new TaskStub();

        name = TaskManagerTest.testAddUserTask(user.name, user.role, user.email, user.address);
        System.out.println("The user: " + user + "was added");
        TaskManagerTest.testDeleteTask(task.taskId);
        System.out.println("The task was deleted");
        TaskManagerTest.testAddTask(task.id, task.title, task.description);
        System.out.println("The task was added");
        TaskManagerTest.testUpdateTask(task.id, "New Title", task.description);
        System.out.println("The task was updated");
    }
}
