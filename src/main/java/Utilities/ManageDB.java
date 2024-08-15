package Utilities;

import Connection.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageDB {
    public static boolean addItem(String type, String name, int entity, int price,String country){
        try(Connection connection = SQLServerConnection.getConnection()){
            String query = "insert into catalog (type,name,entity,price,country) values ('" + type + "','" +name+"',"+entity+","+price+",'"+country+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted>0) return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static void deleteProductFromDB(Product product) {
        String sql = "DELETE FROM catalog WHERE id = ?";

        try (Connection connection = SQLServerConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateProductEntityInDatabase(int productId, int newEntityValue) {
        String sql = "UPDATE catalog SET entity = ? WHERE id = ?";

        try (Connection connection = SQLServerConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newEntityValue);
            statement.setInt(2, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
