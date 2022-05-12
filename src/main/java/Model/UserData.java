package Model;

public class UserData {
    int UserId;
    String username;
    private String password;
    String Role;

    public enum Role{
        EMPLOYEE,
        MANAGER,

    }

}
