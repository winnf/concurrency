//task object instead of creating a task using the task service that doesn't exist
public class TaskStub {
    public Integer id(){
        int id = 1234;
        return id;
    }
    
    public String title(){
        String title = "Wash test tubes";
        return title;
    }

    public String description(){
        String desc = "test tubes in room 3001";
        return description;
    }
}

