package fr.eni.doctorsAppt.bo;

public class Specialist extends GeneralPractitioner {
    private String speciality;

    public Specialist(String lastName, String firstName, String phone, Address address, String speciality, int price) {
        super(lastName, firstName, phone, address);
        this.speciality = speciality;
        apptPrice = price;
    }

    @Override
    public void display() {
        System.out.println(this.lastName.toUpperCase() + " " + this.firstName);
        System.out.println("Phone number : " + this.phone);
        System.out.println("Speciality : " + this.speciality);
        System.out.println("Appointment price : " + apptPrice);
        System.out.println("Address :");
        this.address.display();
        for (TimeSlots timeSlot : timeSlots) {
            if (timeSlot != null) {
                timeSlot.displaySlot();
            }
        }
    }
}
