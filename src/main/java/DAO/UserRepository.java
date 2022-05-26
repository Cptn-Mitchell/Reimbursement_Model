package DAO;
import Model.UserData;
import org.eclipse.jetty.server.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.ConnectionFactory;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class UserRepository {
    Connection conn;
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
    public List<UserData>getAllUsers() {
        List<UserData> users = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From Employee");
            while (rs.next()) {
                UserData u = new UserData(rs.getInt("UserID"), rs.getString("Username"),
                        rs.getString("UserRole"));
                users.add(u);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
