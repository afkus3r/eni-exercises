package fr.eni.doctorsAppt.bo;

public class GeneralPractitioner {
    private String lastName;
    private String firstName;
    private String phone;

    private static int apptPrice;

    public GeneralPractitioner(String lastName, String firstName, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
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
        
    }
}
