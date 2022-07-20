package fr.eni.doctorsAppt.bo;

import java.time.LocalTime;

public class TimeSlots {
    private LocalTime startTime;
    private int duration;
    private GeneralPractitioner doctor;

    public TimeSlots(LocalTime startTime, int duration, GeneralPractitioner doctor) {
        this.startTime = startTime;
        this.duration = duration;
        this.doctor = doctor;
    }

    public GeneralPractitioner getDoctor() {
        return this.doctor;
    }

    public void displaySlot() {
        System.out.print(this.startTime + " - ");
        System.out.print(this.startTime.plusMinutes(duration));
        System.out.println(" (" + this.duration + "minutes)");
    }
}
