package Service;

import org.eclipse.jetty.server.Authentication;

public class AuthService {

public int register(Authentication.User userToBeRegistered) {
    if(userDao.getbyUsername(userToBeRegistered.getUsername()) != null) {

        throw new NullPointerException("Username is already taken");
    }
    return userDAO.create(userToBeRegistered);
    }
public User login(String username, String password) {

    User user;

    try {
        user = userDAO.getByUsername(username);

        if (user!=null && password.equals(user.getPassword())) {

            System.out.println("Logged In Successfully!");
            return user;
        }else if (user!=null && !password.equals(user.getPassword())){

            System.out.println("Wrong password!");
            return null;
        }else{

            System.out.println("User Does Not Exist!");
            return null;
        }
    } catch (Exception e) {

        System.out.println("Login Unsuccessful");
        e.printStackTrace();
    }
    return null;
    }


}
