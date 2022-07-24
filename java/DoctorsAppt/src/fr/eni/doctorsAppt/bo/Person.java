package fr.eni.doctorsAppt.bo;

public class Person {
    protected String lastName;
    protected String firstName;
    protected String phone;
    protected Address address;

    public Person(String lastName, String firstName, String phone, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.address = address;
    }
}
