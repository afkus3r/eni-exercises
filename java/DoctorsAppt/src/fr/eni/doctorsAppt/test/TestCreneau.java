package fr.eni.doctorsAppt.test;

import java.time.LocalTime;

import fr.eni.doctorsAppt.bo.Address;
import fr.eni.doctorsAppt.bo.TimeSlots;
import fr.eni.doctorsAppt.bo.GeneralPractitioner;

/**
 * @date 25 oct. 2018
 * @version POO - V1.0
 * @author hboisgontier
 */
public class TestCreneau {
	public static void main(String[] args) {
		System.out.println("__________________________ Créneaux ______________________________");
		Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
				"Saint Herblain");
		GeneralPractitioner melanie = new GeneralPractitioner("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
		TimeSlots c1 = new TimeSlots(LocalTime.of(9, 0), 15, melanie);
		c1.displaySlot();
		System.out.println("Médecin associé à ce créneau : Dr " + c1.getDoctor().getLastName());
		System.out.println("------------------------------------------------------------------");
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(9, 15), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(9, 30), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(9, 45), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(10, 30), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(10, 45), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(11, 15), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(11, 30), 15, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(11, 45), 15, melanie));
		melanie.display();
		System.out.println("------------------------------------------------------------------");
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(14, 0), 30, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(14, 30), 30, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(15, 0), 30, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(15, 30), 30, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(16, 0), 30, melanie));
		melanie.addTimeSlot(new TimeSlots(LocalTime.of(16, 30), 30, melanie)) ;
		melanie.display();
	}
}
