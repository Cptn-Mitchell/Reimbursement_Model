package DAO;

import Model.Reimbursement;
import org.eclipse.jetty.server.ConnectionFactory;

import java.io.ObjectInputFilter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDao {
    public Reimbursement(){
        Connection conn = ConnectionFactory.getConnection();

    }
    public void update(Reimbursement unprocessedReimbursement){
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "Update ers_reimbursements SET resolver = ?, status = ?::status WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,unprocessedReimbursement.getResolver());
            preparedStatement.setObject(2, unprocessedReimbursement.getStatus().name());
            preparedStatement.setInt(3, unprocessedReimbursement.getID());

            preparedStatement.executeUpdate();

            System.out.println("Reimbursement Successfully Updated!");
        }catch (SQLException e){
            System.out.println("Updating Failed!");
            e.printStackTrace();
        }
    }
    public List <Reimbursement> getReimbursementByUser (int userId){
        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "select * from ers_reimbursements where author = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Reimbursement> reimbursements = new ArrayList<>();

            while (resultSet.next()) {
                reimbursements.add(new Reimbursement(
                        resultSet.getInt("id"),
                        resultSet.getInt("author"),
                        resultSet.getInt("result"),
                        resultSet.getString("description"),
                        ReimbursementType.valueOf(resultSet.getString("type")),
                        Reimbursement.Status.valueOf(resultSet.getString("status")),
                        resultSet.getDouble("amount")
                ));
            }
            return reimbursement;

        } catch (SQLException e) {

            System.out.println("Something went wrong obtaining your list!");
            e.printStackTrace();
        }

       return null;
    }
    public Reimbursement getReimbursementById(int id ) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from ers_reimbursements where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                return new Reimbursement(
                        resultSet.getInt("id"),
                        resultSet.getInt("author"),
                        resultSet.getInt("result"),
                        resultSet.getString("description"),
                        ReimbursementType.valueOf(resultSet.getString("type")),
                        Reimbursement.Status.valueOf(resultSet.getString("status")),
                        resultSet.getDouble("amount")
                );
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with the database!");
            e.printStackTrace();

        }
        return null;
    }

    public List <Reimbursement> getByStatus(ObjectInputFilter.Status status) {
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from ers_reimbursements where status = ?::status";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,status.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Reimbursement> reimbursements = new ArrayList<>;
            while (resultSet.next()) {
                reimbursements.add(new Reimbursement(
                        resultSet.getInt("id"),
                        resultSet.getInt("author"),
                        resultSet.getInt("result"),
                        resultSet.getString("description"),
                        ReimbursementType.valueOf(resultSet.getString("type")),
                        Reimbursement.Status.valueOf(resultSet.getString("status")),
                        resultSet.getDouble("amount")

                ));
            }

            return reimbursements;

        }catch (SQLException e ) {
            System.out.println("Something went wrong obtaining the reimbursements!");
            e.printStackTrace();
        }
        return null;
    }
    public List <Reimbursement> getAllReimbursements() {
        try(Connection connection = ConnectionFactory.getConnection()) {

            List<Reimbursement> reimbursements = new ArrayList<>();
            String sql = "Select * from ers_reimbursements";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                reimbursements.add(new Reimbursement(
                        resultSet.getInt("id"),
                        resultSet.getInt("author"),
                        resultSet.getInt("result"),
                        resultSet.getString("description"),
                        ReimbursementType.valueOf(resultSet.getString("type")),
                        Reimbursement.Status.valueOf(resultSet.getString("status")),
                        resultSet.getDouble("amount")
                ));
            }
            return reimbursements;

        }catch (SQLException sqlException) {
            System.out.println("Something went wrong with the database!");
            sqlException.printStackTrace();
        }
        return null;
    }
    public int create(Reimbursement reimbursementToBeSubmitted) {
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO ers_reimbursements (author, description, type, status, amount) VALUES (?,?,?::type, ?::status, ?) RETURNING ers_reimbursements.id";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,reimbursementToBeSubmitted.getAuthor());

            preparedStatement.setString(2, reimbursementToBeSubmitted.getDescription());

            preparedStatement.setObject(3, reimbursementToBeSubmitted.getType().name());

            preparedStatement.setObject(4,reimbursementToBeSubmitted.getStatus().name());

            preparedStatement.setDouble(5, reimbursementToBeSubmitted.getAccount());


            ResultSet resultSet;

            if ((resultSet = preparedStatement.executeQuery()) != null) {

                resultSet.next();

                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Creating reimbursement has failed");
            e.printStackTrace();
        }
        return 0;
    }

}
