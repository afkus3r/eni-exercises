package fr.eni.doctorsAppt.bo;

public class Address {
    private String additional;
    private int streetNb;
    private String zipTown;

    public Address (String additional, int streetNb, String zipTown) {
        this.additional = additional;
        this.streetNb = streetNb;
        this.zipTown = zipTown;
    }

    public  Address (int streetNb, String zipTown) {
        this.additional = null;
        this.streetNb = streetNb;
        this.zipTown = zipTown;
    }
}
