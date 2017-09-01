package nguyenvt.dtos;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {
    private int itemId;
    private float itemTotal;
    private int itemStatus;
    private String itemReason;
    private String itemNote;
    private int productId;
    private int orderId;

    public OrderItemDTO() {
    }

    public OrderItemDTO(int itemId, float itemTotal, int itemStatus, String itemReason, String itemNote, int productId, int orderId) {
        this.itemId = itemId;
        this.itemTotal = itemTotal;
        this.itemStatus = itemStatus;
        this.itemReason = itemReason;
        this.itemNote = itemNote;
        this.productId = productId;
        this.orderId = orderId;
    }

    public OrderItemDTO(float itemTotal, int itemStatus, String itemReason, String itemNote, int productId, int orderId) {
        this.itemTotal = itemTotal;
        this.itemStatus = itemStatus;
        this.itemReason = itemReason;
        this.itemNote = itemNote;
        this.productId = productId;
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public float getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(float itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(int itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getItemReason() {
        return itemReason;
    }

    public void setItemReason(String itemReason) {
        this.itemReason = itemReason;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
