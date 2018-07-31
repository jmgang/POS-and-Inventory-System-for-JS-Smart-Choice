
package system.model;

/**
 *
 * @author JANSEN ANG
 */
public class SalesByDateBean {
    private int productId, quantity;
    private float costs, sales, profits;
    private String barcode, date;
    private String showProducts;

    public SalesByDateBean( String date, int quantity, float costs, float sales, 
            float profits) {
       
        this.quantity = quantity;
        this.costs = costs;
        this.sales = sales;
        this.profits = profits;
        this.date = date;

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public float getProfits() {
        return profits;
    }

    public void setProfits(float profits) {
        this.profits = profits;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShowProducts() {
        return showProducts;
    }

    public void setShowProducts(String showProducts) {
        this.showProducts = showProducts;
    }
    
    
    
    
}
