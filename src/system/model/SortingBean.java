
package system.model;

/**
 *
 * @author JANSEN
 */
public class SortingBean {
    private String name;
    private int qty;
    private float value;

    public SortingBean(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    public SortingBean(String name, float value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    
}
