
package system.model;

import java.util.Date;

public class POSBean {
    private int productId, qty;
    private String barcode, pname, pdesc, cat;
    private Date date;
    private float sellPrice;

    public POSBean(int productId, String barcode, String pname, String pdesc, String cat,
            float sellPrice, int qty) {
        this.productId = productId;
        this.qty = qty;
        this.barcode = barcode;
        this.pname = pname;
        this.pdesc = pdesc;
        this.cat = cat;
        this.sellPrice = sellPrice;
        this.date = new Date();
    }
   
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    
    
}
