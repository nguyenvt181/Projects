package nguyenvt.dto;

import java.io.Serializable;

public class GroupDTO implements Serializable {
    private int groupId;
    private String groupName;

    public GroupDTO() {
    }

    public GroupDTO(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
