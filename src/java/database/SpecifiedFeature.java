package database;
// Generated Dec 18, 2019 4:06:31 PM by Hibernate Tools 3.6.0



/**
 * SpecifiedFeature generated by hbm2java
 */
public class SpecifiedFeature  implements java.io.Serializable {


     private Integer id;
     private Feature feature;
     private Category category;

    public SpecifiedFeature() {
    }

    public SpecifiedFeature(Feature feature, Category category) {
       this.feature = feature;
       this.category = category;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Feature getFeature() {
        return this.feature;
    }
    
    public void setFeature(Feature feature) {
        this.feature = feature;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }




}


