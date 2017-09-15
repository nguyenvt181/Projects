package nguyenvt.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {
    private int postId;
    private String postTitle;
    private String postContent;
    private String postDate;
    private int accountId;
    private int groupId;
    private int statusId;

    public PostDTO() {
    }

    public PostDTO(String postTitle, String postContent, String postDate, int accountId, int groupId, int statusId) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.accountId = accountId;
        this.groupId = groupId;
        this.statusId = statusId;
    }

    public PostDTO(int postId, String postTitle, String postContent, String postDate, int accountId, int groupId, int statusId) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postDate = postDate;
        this.accountId = accountId;
        this.groupId = groupId;
        this.statusId = statusId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
