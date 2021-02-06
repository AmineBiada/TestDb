package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;


public class LoginModel {
    Connection connection;

    public LoginModel() {
        connection = SQLiteConnection.Connector();
        if (connection == null)
            System.exit(1);
    }

    public boolean isDBConnected() {
        try {
            return !connection.isClosed();

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
    public boolean isLogin (String email, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        String query = "SELECT * FROM " + SQLiteConnection.TABLE_USER + " WHERE " + SQLiteConnection.COLUMN_EMAIL + " = ? AND " +
                SQLiteConnection.COLUMN_PASSWORD + " = ? ";

        try{
            preparedStatement = connection.prepareStatement(query);
            System.out.println(email + " " + password);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            resultset = preparedStatement.executeQuery();
            if(resultset.next()){
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }finally {
            preparedStatement.close();
            resultset.close();
        }
    }
    public String GetUserFLName(String email, String password){
        String string;
        Statement statement = null;
        ResultSet resultset = null;
        try{
            statement = connection.createStatement();
            statement.execute("SELECT " + SQLiteConnection.COLUMN_FIRSTNAME + ", " + SQLiteConnection.COLUMN_LASTNAME +
                    " FROM " + SQLiteConnection.TABLE_USER +
                    " WHERE " + SQLiteConnection.COLUMN_EMAIL + " = '" + email + "' AND " + SQLiteConnection.COLUMN_PASSWORD + " = '" + password +"'");
            resultset=statement.getResultSet();
            string = resultset.getString(SQLiteConnection.COLUMN_FIRSTNAME) + " " + resultset.getString(SQLiteConnection.COLUMN_LASTNAME);
            return string;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Erreur";
        }
    }
    public String GetUserRole(String email, String password){
        String string;
        Statement statement = null;
        ResultSet resultset = null;
        try{
            statement = connection.createStatement();
            statement.execute("SELECT " + SQLiteConnection.COLUMN_ROLE +
                    " FROM " + SQLiteConnection.TABLE_USER +
                    " WHERE " + SQLiteConnection.COLUMN_EMAIL + " = '" + email + "' AND " + SQLiteConnection.COLUMN_PASSWORD + " = '" + password +"'");
            resultset=statement.getResultSet();
            string = resultset.getString(SQLiteConnection.COLUMN_ROLE);
            return string;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Erreur";
        }
    }
}

