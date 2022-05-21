package DAO;
import org.eclipse.jetty.server.ConnectionFactory;


public class UserRepository {
    public UserRepository(){
        conn = ConnectionFactory.getConnection();
        try{
            conn.setAutoCommit(false);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void getUsersById(){

    }
}
