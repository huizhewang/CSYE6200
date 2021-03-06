package edu.neu.csye6200.registry;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
//import java.util.Scanner;
import java.util.logging.Logger;


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
	
	//Log information messages for save()
		
	private void save2(VehicleRegistry lt, String filename){
		Vehicle v2=new Vehicle();
		v2.setMake("BMW");
		v2.setModel("i8");
		v2.setLicense("VBG 777");
		v2.setPassengers(4);
		v2.setFuelCap(11);
		v2.setModelYear(2012);
		v2.setKpl(46.5);
		
		try {   
            PrintStream ps = new PrintStream(new FileOutputStream(filename));
           
            	ps.println("Make: " + v2.getMake()); 
	            ps.println("Model: " + v2.getModel()); 
	            ps.println("License: " + v2.getLicense());
	            ps.println("Passengers: " + v2.getPassengers());
	            ps.println("Fuelcap: " + v2.getFuelCap());
	            ps.println("Model Year: " + v2.getModelYear());
	            ps.println("Kilometers per liter: " + v2.getKpl());
	            ps.println("Range:" + (int)(v2.getKpl()/0.43*v2.getFuelCap()));
	            ps.println(" ");
    		
            ps.close();
            
            
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}		

	/**
	 * This is where your program starts
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
		Logger LOGGER = Logger.getLogger(Vehicle.class.getName());
		try{
			FileHandler fileHandler = new FileHandler("./log.log");
			LOGGER.addHandler(fileHandler);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			LOGGER.config("Configuration done:)");
		// Create an instance of the class, and call the constructor method
		run(); 
		}catch(IOException exception){
			LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);

		}
	}

	public static void run(){
		
//		Vehicle BMW = new Vehicle(4,11,"BMW","i8","VBG 984",2014,47.5);
//	    Vehicle AstonMartin = new Vehicle(2,21,"Aston Martin","DBS","KDE 555",2012,24.1);
//	    System.out.println(BMW.display());
//	    System.out.println("");
//	    System.out.println(AstonMartin.display());
	    VehicleRegistry lt= VehicleRegistry.instance();
//	    System.out.println("");
		lt.testAdd();
//		System.out.println("");
//		lt.testGet();
//		System.out.println("");
//		lt.testRemove();
//		System.out.println("");
//	    lt.testForEach();
		System.out.println("");
		lt.testList();
		System.out.println("");
		
		RegistryIO test1 =new RegistryIO();	
		test1.save(lt,"saveTxt");
		System.out.println("");
		test1.load("saveTxt");
		VehicleTest v3=new VehicleTest();
		VehicleRegistry v2= VehicleRegistry.instance();
		v3.save2(v2, "privateTxt");
//		System.out.println("you can print 'VBG666' or 'KDE888'");
//		
//		Scanner sc=new Scanner(System.in);
//		while(true){
//		VehicleRegistry li = new VehicleRegistry();
//		String inget=sc.next();
//		li.getVehicleByLicense(inget);
//		System.out.println(li.getVehicleByLicense(inget).display());
//		break;
//		}
//		sc.close();
		}
	}		