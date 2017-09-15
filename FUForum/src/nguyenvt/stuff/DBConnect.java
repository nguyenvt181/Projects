package nguyenvt.stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
    public static Connection connectDatabase() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FUForum?autoReconnect=true&useSSL=false", "root", "123456");
        return connection;
    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws Exception {
        if (resultSet != null){
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
