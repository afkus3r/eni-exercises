package fr.eni.doctorsAppt.bo;

public class GeneralPractitioner {
    private String lastName;
    private String firstName;
    private String phone;
    private Address address;
    private static int apptPrice;

    public GeneralPractitioner(String lastName, String firstName, String phone, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.address = address;
        apptPrice = 25;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getApptPrice() {
        return apptPrice;
    }

    public static void setApptPrice(int apptPrice) {
        GeneralPractitioner.apptPrice = apptPrice;
    }

    public String getLastName() {
        return lastName;
    }

    public void display() {
        System.out.println(this.lastName.toUpperCase() + " " + this.firstName);
        System.out.println("Phone number : " + this.phone);
        System.out.println("Appointment price : " + apptPrice);
        System.out.println("Address :");
        this.address.display();
    }
}
