package Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.SQLServerConnection;

public class GetTableData {
    public static List<Product> getProducts(String search){
        List<Product> products = new ArrayList<>();
        try(Connection connection = SQLServerConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from catalog order by name asc");
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("type");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int entity = resultSet.getInt("entity");
                    String country = resultSet.getString("country");
                    products.add(new Product(id,type,name,price,entity,country));
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
