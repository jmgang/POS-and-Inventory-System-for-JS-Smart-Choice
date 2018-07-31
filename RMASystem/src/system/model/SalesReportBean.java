
package system.model;

/**
 *
 * @author JANSEN ANG FRONT AND BACKEND DEVELOPER
 */
public class SalesReportBean {
    private float sales, costs, profits;
    private String date;
    private int quantity;
    private String productName;

    public SalesReportBean( String date, int quantity, float sales, float costs, float profits) {
        this.sales = sales;
        this.costs = costs;
        this.profits = profits;
        this.date = date;
        this.quantity = quantity;
    }

    public SalesReportBean( int quantity , float sales, float costs, float profits, String productName ) {
        this.sales = sales;
        this.costs = costs;
        this.profits = profits;
        this.quantity = quantity;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }

    public float getProfits() {
        return profits;
    }

    public void setProfits(float profits) {
        this.profits = profits;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
  
    
    
}
