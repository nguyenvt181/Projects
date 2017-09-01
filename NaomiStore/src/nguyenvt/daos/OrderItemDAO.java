package nguyenvt.daos;

import nguyenvt.dtos.OrderItemDTO;
import nguyenvt.utilities.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderItemDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    public boolean insertOrderItem(OrderItemDTO itemDTO) throws Exception {
        boolean result;
        try {
            String sql = "INSERT INTO OrderItem(itemTotal, itemStatus, itemReason, itemNote, orderId, productId) VALUES(?, ?, ?, ?, ?, ?)";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, itemDTO.getItemTotal());
            preparedStatement.setInt(2, itemDTO.getItemStatus());
            preparedStatement.setString(3, itemDTO.getItemReason());
            preparedStatement.setString(4, itemDTO.getItemNote());
            preparedStatement.setInt(5, itemDTO.getOrderId());
            preparedStatement.setInt(6, itemDTO.getProductId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }
}
