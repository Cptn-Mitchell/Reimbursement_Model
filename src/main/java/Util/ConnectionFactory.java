package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
    private ConnectionFactory(){

    }
    public static Connection getConnection(){
        try {
            FileInputStream propertiesInput = new FileInputStream("src/main/resources/sql.properties");

            Properties props= new Properties();
            props.load(propertiesInput);
            String url = (String) props.get("url");
            String username = (String) props.get("username");
            String password = (String) props.get("password");

            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
