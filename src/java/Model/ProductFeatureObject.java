package Model;

public class ProductFeatureObject {
    private String featureName ;
    private String fValue;

    public ProductFeatureObject() {
    }

    public ProductFeatureObject(String featureName, String fValue) {
        this.featureName = featureName;
        this.fValue = fValue;
    }

    /**
     * @return the featureName
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * @param featureName the featureName to set
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    /**
     * @return the fValue
     */
    public String getfValue() {
        return fValue;
    }

    /**
     * @param fValue the fValue to set
     */
    public void setfValue(String fValue) {
        this.fValue = fValue;
    }

    
}
