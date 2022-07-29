package fr.eni.stationaryShop.bo;

public class Ream extends Item {
    private int weight;

    // Builders
    public Ream() {
        super();
    }

    public Ream(Integer itemID, String brand, String ref, String designation, float unitaryPrice, int stockQty, int weight) {
        super(itemID, brand, ref, designation, unitaryPrice, stockQty);
        this.weight = weight;
    }

    public Ream(String brand, String ref, String designation, float unitaryPrice, int stockQty, int weight) {
        super(brand, ref, designation, unitaryPrice, stockQty);
        this.weight = weight;
    }

    // Getter and setter
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "Ream [" + "weight=" + weight + ']';
    }
}
