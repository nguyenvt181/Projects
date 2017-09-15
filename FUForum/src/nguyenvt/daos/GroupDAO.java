package nguyenvt.daos;

import nguyenvt.dto.GroupDTO;
import nguyenvt.stuff.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    public List<GroupDTO> getGroupList() throws Exception {
        List<GroupDTO> list;
        try {
            String sql = "SELECT groupId, groupName FROM FUForum.Group";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("groupId");
                String name = resultSet.getString("groupName");
                GroupDTO groupDTO = new GroupDTO(id, name);
                list.add(groupDTO);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return list;
    }
}
