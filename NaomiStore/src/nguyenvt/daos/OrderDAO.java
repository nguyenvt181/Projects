package nguyenvt.daos;

import nguyenvt.dtos.OrderDTO;
import nguyenvt.utilities.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    public boolean insertOrder(OrderDTO orderDTO) throws Exception {
        boolean result;
        try {
            String sql = "INSERT INTO Orders(createdDate, orderTotal, accountId) VALUES(?, ?, ?)";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderDTO.getCreatedDate());
            preparedStatement.setFloat(2, orderDTO.getOrderTotal());
            preparedStatement.setInt(3, orderDTO.getAccountId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public int getOrderId() throws Exception {
        int orderId = 0;
        try {
            String sql = "SELECT orderId FROM Orders";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderId = resultSet.getInt("orderId");
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return orderId;
    }
}
