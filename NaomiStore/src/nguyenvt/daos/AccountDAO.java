package nguyenvt.daos;

import nguyenvt.dtos.AccountDTO;
import nguyenvt.utilities.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;

    public AccountDTO checkLogin(String username, String password) throws Exception {
        AccountDTO accountDTO = null;
        try {
            String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("accountId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("mail");
                int role = resultSet.getInt("role");
                accountDTO = new AccountDTO(id, username, password, name, email, role);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return accountDTO;
    }

    public boolean insertAccount(AccountDTO dto) throws Exception {
        boolean result;
        try {
            String sql = "INSERT INTO Account(username, password, name, mail, role) VALUES(?, ? ,?, ?, ?)";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dto.getUsername());
            preparedStatement.setString(2, dto.getPassword());
            preparedStatement.setString(3, dto.getName());
            preparedStatement.setString(4, dto.getEmail());
            preparedStatement.setInt(5, dto.getRole());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public boolean updateAccount(AccountDTO dto) throws Exception {
        boolean result;
        try {
            String sql = "UPDATE Account SET password = ?, name = ?, mail = ? WHERE accountId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dto.getPassword());
            preparedStatement.setString(2, dto.getName());
            preparedStatement.setString(3, dto.getEmail());
            preparedStatement.setInt(4, dto.getAccountId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

}
