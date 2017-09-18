package Assign2;

import java.util.Scanner;

/**
 * CSYE 6200 Assignment #2 starter file
 */

/**
 * A special class used to test the Vehicle class
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */
public class VehicleTest {

	/**
	 * This is where your program starts
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an instance of the class, and call the constructor method
		VehicleTest test = new VehicleTest();	
		test.run(); 
	}

	public void run(){
		
		Vehicle BMW = new Vehicle(4,11,"BMW","i8","VBG 984",2014,47.5);
	    Vehicle AstonMartin = new Vehicle(2,21,"Aston Martin","DBS","KDE 555",2012,24.1);
	    System.out.println(BMW.display());
	    System.out.println("");
	    System.out.println(AstonMartin.display());
	  
	    VehicleRegistry lt=new VehicleRegistry(); 
	    System.out.println("");
		lt.testAdd();
		System.out.println("");
		lt.testGet();
		System.out.println("");
		lt.testRemove();
		System.out.println("");
		lt.testForEach();
		
		System.out.println("");
		System.out.println("you can print 'VBG666' or 'KDE888'");
		Scanner sc=new Scanner(System.in);
		while(true){
			VehicleRegistry li = new VehicleRegistry();
			String inget=sc.next();
			li.getVehicleByLicense(inget);
			System.out.println(li.getVehicleByLicense(inget).display());
		}
	}
}