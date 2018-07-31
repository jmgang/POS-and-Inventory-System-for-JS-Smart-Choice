
package system.model;

import java.util.Date;


public class WareHouseBean {
    private int productId, inStock, onOrder, qty;
    private String productName, productDesc, cat, supp, barcode;
    private float cost, sellPrice, markUp;
    private Date date;
    
    public WareHouseBean(){
        
    }
    public WareHouseBean(int productId, String barcode, String productName, String productDesc,
                    String cat,  int inStock, float cost, int onOrder, String supp) {
        this.productId = productId;
        this.inStock = inStock;
        this.onOrder = onOrder;
        this.productName = productName;
        this.productDesc = productDesc;
        this.cat = cat;
        this.supp = supp;
        this.cost = cost;
        this.barcode = barcode;
        date = new Date();
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getOnOrder() {
        return onOrder;
    }

    public void setOnOrder(int onOrder) {
        this.onOrder = onOrder;
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

    public String getSupp() {
        return supp;
    }

    public void setSupp(String supp) {
        this.supp = supp;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getMarkUp() {
        return markUp;
    }

    public void setMarkUp(float markUp) {
        this.markUp = markUp;
    }
    
    
}
