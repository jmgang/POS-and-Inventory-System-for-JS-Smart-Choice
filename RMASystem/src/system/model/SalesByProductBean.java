
package system.model;

/**
 *
 * @author JANSEN ANG
 */
public class SalesByProductBean {
    private String productName, barcode, cat, productDesc;
    private int quantity, productId;
    private float sales, profit, costs;

   public SalesByProductBean(int productId, String barcode, String productName, String productDesc,
            String cat, int quantity, float costs, float sales, float profit) {
        this.productName = productName;
        this.quantity = quantity;
        this.sales = sales;
        this.profit = profit;
        this.productId = productId;
        this.barcode = barcode;
        this.productDesc = productDesc;
        this.cat = cat;
        this.costs = costs;
        
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }
    
    
    
    
    
}
