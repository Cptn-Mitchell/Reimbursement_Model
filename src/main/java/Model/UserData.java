package Model;

public class UserData {
    private int UserId;
    private String username;
    private String password;
    private String Role;

    public UserData(String username, String password) {

    }

    public void setUserID(int size) {

    }

    public int getUserID() {
        return 0;
    }

    public enum Role{
        EMPLOYEE,
        MANAGER,

    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "UserId=" + UserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
    /*
    public boolean equals(UserData u){
        if(u.getPassword() == password && u.getUsername() == username){
            return true;

        }
        return false;
    }*/
}

