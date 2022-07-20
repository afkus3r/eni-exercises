package fr.eni.doctorsAppt.test;

import fr.eni.doctorsAppt.bo.Address;
import fr.eni.doctorsAppt.bo.GeneralPractitioner;

public class TestDoctor {

	public static void main(String[] args) {
		System.out.println("__________________________ Médecins ______________________________");
		GeneralPractitioner melanie = new GeneralPractitioner("Malalaniche", "Mélanie", "02.28.03.17.28");
		GeneralPractitioner edmond = new GeneralPractitioner("Bosapin", "Edmond", "+33 2 17 18 19 20");
		GeneralPractitioner djemila = new GeneralPractitioner("Table", "Djémila", "03-04-05-06-07");

		melanie.display();
		System.out.println("------------------------------------------------------------------");
		edmond.display();
		System.out.println("------------------------------------------------------------------");
		djemila.display();

		System.out.println("--------------- Changement du numéro de ce médecin ---------------");
		djemila.setPhone("07-06-05-04-03");
		System.out.printf("Nouveau numéro du Dr %s : %s%n", djemila.getLastName(), djemila.getPhone());
		
		System.out.println("-------------- Changement du prix de la consultation -------------");
		GeneralPractitioner.setApptPrice(23);
		melanie.display();
		System.out.println("------------------------------------------------------------------");
		edmond.display();
		System.out.println("------------------------------------------------------------------");
		djemila.display();
	}
}
