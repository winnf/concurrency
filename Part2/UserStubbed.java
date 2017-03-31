//user object instead of creating a user using the user service
//returns what the userservice would have
public class UserStubbed {
    public String name(){
        return "Tammy Tester";
    }
    
    public String email(){
        return "tammy_t@gmail.com";
    }

    public String address(){
        return "123 Testing Address";
    }

    public Role role(){
        return "student";
    }
}
