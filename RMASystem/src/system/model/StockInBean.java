
package system.model;

import java.util.Date;

/**
 *
 * @author JANSEN
 */
public class StockInBean {
    private int productId, quantity;
    private String productName, productDesc, cat, barcode, supplier;
    private float cost, total;
    private Date date;

    public StockInBean(int productId,  String barcode,String productName, String productDesc, String cat,
           int quantity, float cost, float total, String supplier,java.sql.Timestamp date) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productDesc = productDesc;
        this.cat = cat;
        this.barcode = barcode;
        this.supplier = supplier;
        this.cost = cost;
        this.total = total;
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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
