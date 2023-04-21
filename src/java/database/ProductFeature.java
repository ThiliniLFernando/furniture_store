package database;
// Generated Dec 18, 2019 4:06:31 PM by Hibernate Tools 3.6.0



/**
 * ProductFeature generated by hbm2java
 */
public class ProductFeature  implements java.io.Serializable {


     private Integer id;
     private Product product;
     private Feature feature;
     private String featureValue;

    public ProductFeature() {
    }

    public ProductFeature(Product product, Feature feature, String featureValue) {
       this.product = product;
       this.feature = feature;
       this.featureValue = featureValue;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Feature getFeature() {
        return this.feature;
    }
    
    public void setFeature(Feature feature) {
        this.feature = feature;
    }
    public String getFeatureValue() {
        return this.featureValue;
    }
    
    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }




}

