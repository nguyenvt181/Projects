package nguyenvt.daos;

import nguyenvt.dto.RoleDTO;
import nguyenvt.stuff.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    public List<RoleDTO> getListRole() throws Exception{
        List<RoleDTO> list;
        try {
            String sql = "SELECT roleId, roleName FROM FUForum.Role";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("roleId");
                String name = resultSet.getString("roleName");
                RoleDTO roleDTO = new RoleDTO(id, name);
                list.add(roleDTO);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return list;
    }

    public boolean updateRole(RoleDTO roleDTO) throws Exception {
        boolean result;
        try {
            String sql = "UPDATE FUForum.Role SET roleName = ? WHERE roleId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roleDTO.getRoleName());
            preparedStatement.setInt(2, roleDTO.getRoleId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }
}
