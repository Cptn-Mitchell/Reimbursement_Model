package Service;


import Model.UserData;
import org.eclipse.jetty.server.Authentication;

import java.util.ArrayList;

public class UserService {



    ArrayList<UserData> users;
    public UserService(){
        users = new ArrayList<UserData>();
    }

    public static String getPassword() {
        return null;
    }

    public static String getUsername() {
        return null;
    }

    public int register (String username, String password) {
        UserData newUser = new UserData(username, password);
        if (users.contains(newUser)) {
            return 0;
        } else {
            newUser.setUserID(users.size());
            users.add(newUser);
            return newUser.getUserID();
        }
    }
    public UserData login(String username, String password){
        for(UserData u : users){
            if(u.getUsername().equals(username)){
                if(u.getPassword().equals(password)){
                    return u;
                }
            }
        }
        return null;
    }

    public String getUserByUsername(String handlerId) {
        return null;
    }

    public Integer getUserByID(int handlerId) {
        return null;
    }

    public ArrayList<UserData> getAllUsers() {
        ArrayList<UserData> allUsers = new ArrayList<>();
        return allUsers;

    }

    public String getUsersByRole(String handlerId) {
        return null;
    }
}
