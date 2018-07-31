
package system.model;

import java.sql.Timestamp;
import java.util.Date;


public class StockOutBean {
    private int productId, qty;
    private String barcode, invoice, pname, pdesc, cat;
    private float sellPrice, total;
    private java.sql.Timestamp date;

    public StockOutBean(int ProductId, String barcode, String invoice, String pname, String pdesc, String cat, int qty, 
            float sellPrice, float total, java.sql.Timestamp date) {
        this.productId = ProductId;
        this.qty = qty;
        this.barcode = barcode;
        this.invoice = invoice;
        this.pname = pname;
        this.cat = cat;
        this.sellPrice = sellPrice;
        this.total = total;
        this.pdesc = pdesc;
        this.date = date;
    }
    
    
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int ProductId) {
        this.productId = ProductId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }    
    
}
