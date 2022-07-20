package fr.eni.doctorsAppt.bo;

import java.time.LocalDate;

public class Appointments {
    private TimeSlots timeSlot;
    private Patient patient;
    private LocalDate date;

    public Appointments(TimeSlots timeSlot, Patient patient, LocalDate date) {
        this.timeSlot = timeSlot;
        this.patient = patient;
        this.date = date;
    }

    public void display() {
        System.out.print("Rendez vous du " + this.date + " ");
        this.timeSlot.displaySlot();
        System.out.println("avec le ");
        System.out.print("pour ");
        this.patient.display();
    }
}
