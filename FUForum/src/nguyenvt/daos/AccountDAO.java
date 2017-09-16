package nguyenvt.daos;

import nguyenvt.dto.AccountDTO;
import nguyenvt.stuff.DBConnect;

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
            String sql = "SELECT accountId, name, email, roleId FROM FUForum.Account WHERE username = ?  AND password = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("accountId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int roleId = resultSet.getInt("roleId");
                accountDTO = new AccountDTO(id, username, password, name, email, roleId);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return accountDTO;
    }

    public boolean insertAccount(AccountDTO accountDTO) throws Exception {
        boolean result;
        try {
            String sql = "INSERT INTO FUForum.Account(username, password, name, email, roleId) VALUES(?, ?, ?, ?, ?)";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountDTO.getUsername());
            preparedStatement.setString(2, accountDTO.getPassword());
            preparedStatement.setString(3, accountDTO.getName());
            preparedStatement.setString(4, accountDTO.getEmail());
            preparedStatement.setInt(5, accountDTO.getRoleId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public boolean updateAccount(AccountDTO accountDTO) throws Exception {
        boolean result;
        try {
            String sql = "UPDATE FUForum.Account SET password = ?, name = ?, email = ? WHERE accountId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountDTO.getPassword());
            preparedStatement.setString(2, accountDTO.getName());
            preparedStatement.setString(3, accountDTO.getEmail());
            preparedStatement.setInt(4, accountDTO.getAccountId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }
}
