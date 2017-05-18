package test;

import Repository.PicoPlacaRepository;

public class main {
	/*
	 * Using object-oriented, tested code using the language that you feel most
	 * proficient in, please write a "pico y placa" predictor. The inputs should
	 * be a license plate number (the full number, not the last digit), a date
	 * (as a String), and a time, and the program will return whether or not
	 * that car can be on the road.
	 * 
	 * Language : JAVA / JSP 
	 * Bootstraps 3.0
	 */
	public static void main(String[] args) {
		PicoPlacaRepository v = new PicoPlacaRepository();
		System.out.println(v.checkPicoPlaca("GNB-0695", "2017-05-17", "09:00"));
	}

}
