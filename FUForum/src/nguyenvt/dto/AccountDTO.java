package nguyenvt.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable {
    private int accountId;
    private String username;
    private String password;
    private String name;
    private String email;
    private int roleId;

    public AccountDTO() {
    }

    public AccountDTO(int accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    public AccountDTO(String username, String password, String name, String email, int roleId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roleId = roleId;
    }

    public AccountDTO(int accountId, String username, String password, String name, String email, int roleId) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roleId = roleId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
