/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thu.dev.data.dao.model;

import java.io.Serializable;

/**
 *
 * @author Nguyen Thu
 */
public class OrderDetailSession implements Serializable{
    private int productId;;
    private String productName;
    private String img;
    private double price;
    private int quantity;

    public OrderDetailSession(int productId, String productName, String img, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
    