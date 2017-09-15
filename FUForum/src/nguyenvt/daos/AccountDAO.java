package nguyenvt.daos;

import nguyenvt.dto.AccountDTO;
import nguyenvt.stuff.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet;

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
}
