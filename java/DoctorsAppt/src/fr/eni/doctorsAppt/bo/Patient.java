package fr.eni.doctorsAppt.bo;

import java.time.LocalDate;
import java.util.Objects;

public class Patient {
    private String lastName;
    private String firstName;
    private String phone;
    private char sex;
    private long ssn;
    private LocalDate birthDate ;
    private String comments;
    private Address address;

    public Patient(String lastName, String firstName, String phone, char sex, long ssn, LocalDate birthDate, String comments, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.sex = sex;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.comments = comments;
        this.address = address;
    }

    public void display() {
        System.out.println(this.lastName.toUpperCase() + " " + this.firstName);
        System.out.println("Phone number : " + this.phone);
        switch (this.sex) {
            case 'F' -> System.out.println("Féminin");
            case 'M' -> System.out.println("Masculin");
        }
        System.out.println("SSN : " + this.ssn);
        System.out.println("Birth date : " + this.birthDate);
        System.out.println(Objects.requireNonNullElse(this.comments, "Pas de commentaire"));
        System.out.println("Address :");
        this.address.display();
    }
}
