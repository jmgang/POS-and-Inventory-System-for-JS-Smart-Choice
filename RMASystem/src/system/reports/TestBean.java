
package system.reports;

/**
 *
 * @author JANSEN
 */
public class TestBean {
    private int productId;
    private String productName, productDesc;
    private int qty;
    private float sellPrice;

    public TestBean() {
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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    

    public TestBean(int productId, String productName, String productDesc, int qty, float sellPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.qty = qty;
        this.sellPrice = sellPrice;
    }
    
    
    
    
}
