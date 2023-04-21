package database;
// Generated Dec 18, 2019 4:06:31 PM by Hibernate Tools 3.6.0



/**
 * OrderProduct generated by hbm2java
 */
public class OrderProduct  implements java.io.Serializable {


     private Integer id;
     private Order order;
     private Product product;
     private double orderPrice;
     private int orderQty;
     private double rowTotal;
     private Double rowDiscount;
     private double rowSubTotal;
     private String opStatus;

    public OrderProduct() {
    }

	
    public OrderProduct(Order order, Product product, double orderPrice, int orderQty, double rowTotal, double rowSubTotal, String opStatus) {
        this.order = order;
        this.product = product;
        this.orderPrice = orderPrice;
        this.orderQty = orderQty;
        this.rowTotal = rowTotal;
        this.rowSubTotal = rowSubTotal;
        this.opStatus = opStatus;
    }
    public OrderProduct(Order order, Product product, double orderPrice, int orderQty, double rowTotal, Double rowDiscount, double rowSubTotal, String opStatus) {
       this.order = order;
       this.product = product;
       this.orderPrice = orderPrice;
       this.orderQty = orderQty;
       this.rowTotal = rowTotal;
       this.rowDiscount = rowDiscount;
       this.rowSubTotal = rowSubTotal;
       this.opStatus = opStatus;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public double getOrderPrice() {
        return this.orderPrice;
    }
    
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
    public int getOrderQty() {
        return this.orderQty;
    }
    
    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
    public double getRowTotal() {
        return this.rowTotal;
    }
    
    public void setRowTotal(double rowTotal) {
        this.rowTotal = rowTotal;
    }
    public Double getRowDiscount() {
        return this.rowDiscount;
    }
    
    public void setRowDiscount(Double rowDiscount) {
        this.rowDiscount = rowDiscount;
    }
    public double getRowSubTotal() {
        return this.rowSubTotal;
    }
    
    public void setRowSubTotal(double rowSubTotal) {
        this.rowSubTotal = rowSubTotal;
    }
    public String getOpStatus() {
        return this.opStatus;
    }
    
    public void setOpStatus(String opStatus) {
        this.opStatus = opStatus;
    }




}


