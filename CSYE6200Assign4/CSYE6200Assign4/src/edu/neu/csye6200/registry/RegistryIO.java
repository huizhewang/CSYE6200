package edu.neu.csye6200.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
public class RegistryIO {

	public static final Logger Log = Logger.getLogger(Vehicle.class.getName());

	public RegistryIO() {
    	Log.info(RegistryIO.class.getName()+ " created!");

	}
	
	public void save(){
		
		Log.info("Save() method loaded");
		
		try{
			 VehicleRegistry reg = VehicleRegistry.getInstance();
	         FileOutputStream fos= new FileOutputStream("mycar");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(reg.list);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	    	   Log.severe("Save ioexception error!");
	            ioe.printStackTrace();
	        }	
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public void load(){
		
		Log.info("Load() method loaded");

		
		ArrayList<Vehicle> readlist= new ArrayList<Vehicle>();
		try
	       {	
	           FileInputStream fis = new FileInputStream("mycar");
	           ObjectInputStream ois = new ObjectInputStream(fis);
	           readlist = (ArrayList<Vehicle>) ois.readObject();
	           ois.close();
	           fis.close();
	        }catch(IOException ioe){
	        	Log.severe("Load ioexception error!");
	            ioe.printStackTrace();
	            return;
	        }catch(ClassNotFoundException cnf){
	             System.out.println("Class not found");
	             cnf.printStackTrace();
	             return;
	        }
		for(int i = 0 , len= readlist.size();i<len;++i){
			System.out.println(readlist.get(i).display());
		}
        System.out.println("Loaded from file\"mycar\"successfully!");

	
	}
	
}

