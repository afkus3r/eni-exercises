package fr.eni.doctorsAppt.bo;

import java.time.LocalDate;

public class Patient {
    private String lastName;
    private String firstName;
    private String phone;
    private char sex;
    private long ssn;
    private LocalDate birthDate ;
    private String comments;

    public void display() {
        System.out.println(this.lastName.toUpperCase() + " " + this.firstName);
        System.out.println("Phone number : " + this.phone);
        System.out.println("Sex : " + this.sex);
        System.out.println("SSN : " + this.ssn);
        System.out.println("Birth date : " + this.birthDate);
        System.out.println("Comments : " + this.comments);
    }
}
