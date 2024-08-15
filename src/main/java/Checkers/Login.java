package Checkers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.SQLServerConnection;

public class Login {
    public static String loginCheck(String useremail, String password){
        PreparedStatement preparedStatement;

        try(Connection connection = SQLServerConnection.getConnection()){
            String query = "select email , password,status from users where email ='" + useremail + "'";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbEmail = resultSet.getString("email");
                String dbPassword = resultSet.getString("password");
                String dbStatus = resultSet.getString("status");

                if (dbEmail != null && dbEmail.equals(useremail) && dbStatus.equals("owner")){
                    if(password.equals("qwertyzxcv")){
                        return "owner";
                    }
                }
                if (dbEmail != null && dbEmail.equals(useremail)) {
                    if (dbPassword.equals(password)){
                        System.out.println("Login successful");
                        return "user";
                    }else{
                        System.out.println("Invalid password");
                        return "incorrectPassword";
                    }
                }else{
                    System.out.println("User not found");
                    return "not found";
                }
            } else{
                System.out.println("User not found");
                return "not found";
            }


        } catch (SQLException e){
            System.out.println(e);
        }

        return "";
    }
}
