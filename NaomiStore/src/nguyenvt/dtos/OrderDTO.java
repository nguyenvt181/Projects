package nguyenvt.dtos;

import java.io.Serializable;

public class OrderDTO implements Serializable {
    private int orderId;
    private float orderTotal;
    private int accountId;
    private String createdDate;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, float orderTotal, int accountId, String createdDate) {
        this.orderId = orderId;
        this.orderTotal = orderTotal;
        this.accountId = accountId;
        this.createdDate = createdDate;
    }

    public OrderDTO(float orderTotal, int accountId, String createdDate) {
        this.orderTotal = orderTotal;
        this.accountId = accountId;
        this.createdDate = createdDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
