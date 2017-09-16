package nguyenvt.daos;

import nguyenvt.dto.AccountDTO;
import nguyenvt.dto.GroupDTO;
import nguyenvt.dto.PostDTO;
import nguyenvt.stuff.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    private List<PostDTO> postDTOList;
    private List<AccountDTO> accountDTOList;
    private List<GroupDTO> groupDTOList;

    public List<PostDTO> getPostDTOList() {
        return postDTOList;
    }

    public List<AccountDTO> getAccountDTOList() {
        return accountDTOList;
    }

    public List<GroupDTO> getGroupDTOList() {
        return groupDTOList;
    }

    public boolean insertPost(PostDTO postDTO) throws Exception {
        boolean result;
        try {
            String sql = "INSERT INTO FUForum.Post(title, content, createdDate, accountId, groupId, statusId) VALUES(?, ?, ?, ?, ?, ?)";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, postDTO.getPostTitle());
            preparedStatement.setString(2, postDTO.getPostContent());
            preparedStatement.setString(3, postDTO.getPostDate());
            preparedStatement.setInt(4, postDTO.getAccountId());
            preparedStatement.setInt(5, postDTO.getGroupId());
            preparedStatement.setInt(6, postDTO.getStatusId());
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public void getPostList() throws Exception {
        try {
            String sql = "SELECT p.postId, p.title, p.content, p.createdDate, p.accountId, p.groupId, p.statusId, a.name, g.groupName " +
                    "FROM FUForum.Post p " +
                    "JOIN FUForum.Account a ON a.accountId = p.accountId " +
                    "JOIN FUForum.Group g ON g.groupId = p.groupId";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            postDTOList = new ArrayList<>();
            accountDTOList = new ArrayList<>();
            groupDTOList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("postId");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String createdDate = resultSet.getString("createdDate");
                int accountId = resultSet.getInt("accountId");
                int groupId = resultSet.getInt("groupId");
                int statusId = resultSet.getInt("statusId");
                String name = resultSet.getString("name");
                String groupName = resultSet.getString("groupName");
                PostDTO postDTO = new PostDTO(id, title, content, createdDate, accountId, groupId, statusId);
                AccountDTO accountDTO = new AccountDTO(accountId, name);
                GroupDTO groupDTO = new GroupDTO(groupId, groupName);
                postDTOList.add(postDTO);
                accountDTOList.add(accountDTO);
                groupDTOList.add(groupDTO);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
    }

    public void getOwnPost(int accountId) throws Exception {
        try {
            String sql = "SELECT p.postId, p.title, p.content, p.createdDate, p.accountId, p.groupId, p.statusId, g.groupName " +
                    "FROM FUForum.Post p " +
                    "JOIN FUForum.Account a ON a.accountId = ? " +
                    "JOIN FUForum.Group g ON g.groupId = p.groupId";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            resultSet = preparedStatement.executeQuery();
            postDTOList = new ArrayList<>();
            groupDTOList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("postId");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String createdDate = resultSet.getString("createdDate");
                int groupId = resultSet.getInt("groupId");
                int statusId = resultSet.getInt("statusId");
                String groupName = resultSet.getString("groupName");
                PostDTO postDTO = new PostDTO(id, title, content, createdDate, accountId, groupId, statusId);
                GroupDTO groupDTO = new GroupDTO(groupId, groupName);
                postDTOList.add(postDTO);
                groupDTOList.add(groupDTO);
            }
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
    }

    public boolean updateStatus(int postId, int status) throws Exception {
        boolean result;
        try {
            String sql = "UPDATE FUForum.Post SET statusId = ? WHERE postId = ?";
            connection = DBConnect.connectDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, postId);
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            DBConnect.closeConnection(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public boolean updatePost(PostDTO postDTO) throws Exception {
        boolean result;
        return false;
    }
}
