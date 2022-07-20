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

    public void display() {
        System.out.print(startTime + " - ");
        System.out.print(LocalTime.of(startTime.getHour(), startTime.getMinute() + duration));
        System.out.print(" (" + duration + "minutes )");
    }
}
