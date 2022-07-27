package fr.eni.stationaryShop.bo;

public class Pen extends Item {
    private String color;

    // Builders
    public Pen(int itemID, String brand, String ref, String designation, float unitaryPrice, int stockQty, String color) {
        super(itemID, brand, ref, designation, unitaryPrice, stockQty);
        this.color = color;
    }

    public Pen(String brand, String ref, String designation, float unitaryPrice, int stockQty, String color) {
        super(brand, ref, designation, unitaryPrice, stockQty);
        this.color = color;
    }

    // Getter and setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "Pen [color=" + this.color + "]";
    }
}
