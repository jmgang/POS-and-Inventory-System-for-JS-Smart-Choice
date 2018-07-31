
package system.model;


public class SellingAreaBean {
    private String  productName, productDesc, category, barcode;
    private float sellPrice;
    private int qty, productId;

    public SellingAreaBean(int productId, String productName,
            String barcode, String productDesc, String category, float sellPrice, int qty) {
        this.productId = productId;
        this.barcode = barcode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.category = category;
        this.sellPrice = sellPrice;
        this.qty = qty;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
}
