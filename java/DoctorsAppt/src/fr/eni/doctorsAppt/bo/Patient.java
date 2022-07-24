package fr.eni.doctorsAppt.bo;

import java.time.LocalDate;
import java.util.Objects;

public class Patient extends Person{
    private char sex;
    private long ssn;
    private LocalDate birthDate ;
    private String comments;

    public Patient(String lastName, String firstName, String phone, char sex, long ssn, LocalDate birthDate, String comments, Address address) {
        super(lastName, firstName, phone, address);
        this.sex = sex;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.comments = comments;
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
