package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SQLServerConnection {
    private static final String URL = "jdbc:postgresql://ep-solitary-mouse-a42d2yny-pooler.us-east-1.aws.neon.tech:5432/verceldb";
    private static final String USER = "default";
    private static final String PASSWORD = "5ycOWgMLFxw4";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
