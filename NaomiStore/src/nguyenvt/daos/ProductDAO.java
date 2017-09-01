package nguyenvt.daos;

import nguyenvt.dtos.ProductDTO;
import nguyenvt.utilities.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    public List<ProductDTO> getList() throws Exception{
        List<ProductDTO> list = null;
        try {
            String sql = "SELECT * FROM Product";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("productId");
                String name = resultSet.getString("productName");
                int quantity = resultSet.getInt("productQuantity");
                float price = resultSet.getFloat("productPrice");
                ProductDTO productDTO = new ProductDTO(id, name, quantity, price);
                list.add(productDTO);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return list;
    }

    public List<ProductDTO> getList(String searchValue) throws Exception {
        List<ProductDTO> list = null;
        try {
            String sql = "SELECT * FROM Product WHERE productName LIKE ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + searchValue + "%");
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("productId");
                String name = resultSet.getString("productName");
                int quantity = resultSet.getInt("productQuantity");
                float price = resultSet.getFloat("productPrice");
                ProductDTO productDTO = new ProductDTO(id, name, quantity, price);
                list.add(productDTO);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return list;
    }

    public boolean insertProduct(ProductDTO productDTO) throws Exception {
        boolean result;
        try {
            String sql = "INSERT INTO Product(productName, productQuantity, productPrice) VALUES(?, ?, ?)";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productDTO.getProductName());
            preparedStatement.setInt(2, productDTO.getProductQuantity());
            preparedStatement.setFloat(3, productDTO.getProductPrice());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public boolean updateProduct(ProductDTO productDTO) throws Exception {
        boolean result;
        try {
            String sql = "UPDATE Product SET productName = ?, productQuantity = ?, productPrice = ? WHERE productId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productDTO.getProductName());
            preparedStatement.setInt(2, productDTO.getProductQuantity());
            preparedStatement.setFloat(3, productDTO.getProductPrice());
            preparedStatement.setInt(4, productDTO.getProductId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public boolean removeProduct(int productId) throws Exception {
        boolean result;
        try {
            String sql = "DELETE FROM Product WHERE productId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public float getUnitPrice(int productId) throws Exception {
        float price = 0;
        try {
            String sql = "SELECT productPrice FROM Product WHERE productId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                price = resultSet.getFloat("productPrice");
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return price;
    }

    public int getQuantity(int productId) throws Exception {
        int quantity = 0;
        try {
            String sql = "SELECT productQuantity FROM Product WHERE productId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                quantity = resultSet.getInt("productQuantity");
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return quantity;
    }

    public boolean updateQuantity(int productId, int newQuantity) throws Exception {
        boolean result;
        try {
            String sql = "UPDATE Product SET productQuantity = ? WHERE productId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setInt(2, productId);
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }
}
