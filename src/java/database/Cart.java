package database;
// Generated Dec 18, 2019 4:06:31 PM by Hibernate Tools 3.6.0



/**
 * Cart generated by hbm2java
 */
public class Cart  implements java.io.Serializable {


     private Integer id;
     private FrontUser frontUser;
     private Product product;
     private int cartQty;

    public Cart() {
    }

    public Cart(FrontUser frontUser, Product product, int cartQty) {
       this.frontUser = frontUser;
       this.product = product;
       this.cartQty = cartQty;
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
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getCartQty() {
        return this.cartQty;
    }
    
    public void setCartQty(int cartQty) {
        this.cartQty = cartQty;
    }




}


