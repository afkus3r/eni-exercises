package fr.eni.stationaryShop.bo;

public abstract class Item {
    protected Integer itemID;
    protected String ref;
    protected String brand;
    protected String designation;
    protected float unitaryPrice;
    protected int stockQty;

    // Builders
    public Item(Integer itemID, String brand, String ref, String designation, float unitaryPrice, int stockQty) {
        this.itemID = itemID;
        this.brand = brand;
        this.ref = ref;
        this.designation = designation;
        this.unitaryPrice = unitaryPrice;
        this.stockQty = stockQty;
    }

    public Item(String brand, String ref, String designation, float unitaryPrice, int stockQty) {
        this.brand = brand;
        this.ref = ref;
        this.designation = designation;
        this.unitaryPrice = unitaryPrice;
        this.stockQty = stockQty;
    }

    // Getters and setters
    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(float unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    // toString
    @Override
    public String toString() {
        return "Item [itemID=" + this.itemID + ", ref=" + this.ref + ", brand=" + this.brand + ", designation=" + this.designation + ", unitaryPrice=" + this.unitaryPrice + ", stockQty=" + this.stockQty + "]";
    }
}
