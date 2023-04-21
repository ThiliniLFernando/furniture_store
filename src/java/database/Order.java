package database;
// Generated Dec 18, 2019 4:06:31 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order  implements java.io.Serializable {


     private Integer id;
     private FrontUser frontUser;
     private Date orderDate;
     private double subTotal;
     private String orderStatus;
     private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>(0);

    public Order() {
    }

	
    public Order(FrontUser frontUser, Date orderDate, double subTotal, String orderStatus) {
        this.frontUser = frontUser;
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.orderStatus = orderStatus;
    }
    public Order(FrontUser frontUser, Date orderDate, double subTotal, String orderStatus, Set<OrderProduct> orderProducts) {
       this.frontUser = frontUser;
       this.orderDate = orderDate;
       this.subTotal = subTotal;
       this.orderStatus = orderStatus;
       this.orderProducts = orderProducts;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public FrontUser getFrontUser() {
        return this.frontUser;
    }
    
    public void setFrontUser(FrontUser frontUser) {
        this.frontUser = frontUser;
    }
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public double getSubTotal() {
        return this.subTotal;
    }
    
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }
    
    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }




}

