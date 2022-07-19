package fr.eni.doctorsAppt.bo;

public class Address {
    private String additional;
    private String street;
    private String zipTown;

    public Address (String additional, int streetNb, String streetAdd, String streetName, int zip, String town) {
        this.additional = additional;
        this.street = streetNb + " " + streetAdd + " " + streetName;
        this.zipTown = zip + " " + town;
    }

    public  Address (int streetNb, String streetAdd, String streetName, int zip, String town) {
        this.additional = null;
        this.street = streetNb + " " + streetAdd + " " + streetName;
        this.zipTown = zip + " " + town;
    }

    public void display() {
        if (this.additional != null) {
            System.out.println(this.additional);
        }
        System.out.println(street);
        System.out.println(zipTown);
    }
}
