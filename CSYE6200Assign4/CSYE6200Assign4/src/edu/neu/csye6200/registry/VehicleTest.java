package edu.neu.csye6200.registry;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CSYE 6200 Assignment #4 starter file
 */

/**
 * A special class used to test the Vehicle class
 * @author (Pengyu Chen)
 * ID: (001217545)
 *
 */
public class VehicleTest {

	public static final Logger Log = Logger.getLogger(Vehicle.class.getName());

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		VehicleTest test1 = new VehicleTest();		
		FileHandler ioHandler;
		try {
			ioHandler = new FileHandler("./log.log");
			Log.addHandler(ioHandler);
			ioHandler.setLevel(Level.ALL);
			test1.run(); 
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void run() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
	    Scanner in=new Scanner(System.in);
	    VehicleRegistry reg = VehicleRegistry.getInstance();
	    String i ="";
	
	    System.out.println("Input a number to run a certain fuction");
	    System.out.println("1.Get the vehicle from list");
	    System.out.println("2.Add a vehicle in the list");
	    System.out.println("3.Remove a vehicle from list");
	    System.out.println("4.Retrieve your license plate");
	    System.out.println("5.Save vehicles to file");
	    System.out.println("6.Load vehicles from file");
	    System.out.println("7.Print TruckVehicle");
	    System.out.println("8.Sort all of the vehicles by license");
	    System.out.println("q.Quit\n");
	    
	    while(true){
	    	System.out.println("------------------------------------------------------\n");
		    i = in.next();
		    if(i.equals("q")) break;
		    switch(i){
		    case "1": {
		    	reg.getVehicle();
		    	break;
		    }
		    case "2": {
		    	System.out.println("Input the make of the car:");	
		    	String ma=in.next();
		    	System.out.println("Input the model of the car:");	
		    	String mo=in.next();
		    	System.out.println("Input the year of the car:");	
		    	int ye=in.nextInt();
		    	System.out.println("Input the passenger capacity of the car:");	
		    	int pa=in.nextInt();
		    	System.out.println("Input the fuel capacity of the car:(int)");	
		    	int fu=in.nextInt();
		    	System.out.println("Input the KPL of the car:");	
		    	double k=in.nextDouble();
		    	System.out.println("Input the license of the car:(No space)");	
		    	String li=in.next();
		    	Vehicle temp = new Vehicle(li,ma,mo,ye,pa,fu,k);	    	
		    	reg.addVehicle(temp);
		    	save(temp,ma);
		    	System.out.println("Your car has been saved successfully!");
		    	break;
		    }
		    case "3":{
		    	System.out.println("Which vehicle do you want to remove?");
		    	String na2 = in.next();
		    	reg.removeVehicle(na2);
		    	break;
		    }
		    case "4": {
		    	System.out.println("Input the license plate to retrieve the vehicle.");
				String inget=in.next();
		    	reg.getMap(inget);
		    	break;
		    }
		    case "5":{
		    	RegistryIO newio = new RegistryIO();
		    	newio.save();
		    	System.out.println("Your carlist has been saved to file named\"mycar\".");
		    	break;
		    }
		    case "6":{
		    	RegistryIO newio = new RegistryIO();
		    	newio.load();
		    	break;
		    }
		    case "7":{
		    	TruckVehicle show = new TruckVehicle(22.05,7.45,7.15,"VBG984", "Toyota", "Tacoma", 2017,4,70,10.63);
		    	System.out.println(show.display());
		    	break;	    			
		    }
		    case "8" :{
		    	VehicleRegistry regsort = VehicleRegistry.getInstance();
		    	regsort.sortList();
		    }
		    case "q": break;
		 
		    default: System.out.println("Invalid input.");	
		    }
		    
	    }
	    in.close();
	    System.out.println("Quiting...");
	    
	}
	
	//Private save method is used in function 2.
	private void save(Vehicle temp, String file){
		
		try {   
            PrintStream p = new PrintStream(new FileOutputStream(file));
            p.println(temp.display()); 
            p.close();
            
            
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }		
		
	}
}

