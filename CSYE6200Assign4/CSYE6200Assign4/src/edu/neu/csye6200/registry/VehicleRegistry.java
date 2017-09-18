package edu.neu.csye6200.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

// Singleton
public class VehicleRegistry {
	public static final Logger Log = Logger.getLogger(Vehicle.class.getName());
	private static VehicleRegistry instance=null;
    public static VehicleRegistry getInstance(){
        if(instance==null){
        	instance=new VehicleRegistry();
        }
        return instance;
    }
    private VehicleRegistry() {
    	Log.info(VehicleRegistry.class.getName()+" created!");
    }
	
	Vehicle v1=new Vehicle("VBG984", "Volvo", "S80", 2016,4,70,10.63);
	Vehicle v2=new Vehicle("KDE633", "Ford","Mustang",2017,4,60,9.35);
	Vehicle v3=new Vehicle("YEV742", "Make3","Model3",2015,2,66,9.45);
	Vehicle v4=new Vehicle("AEN293", "Make4","Model4",2014,4,61,9.55);
	Vehicle v5=new Vehicle("PEK345", "Make5","Model5",2013,2,68,9.65);
	Vehicle v6=new Vehicle("LMZ312", "Make6","Model6",2012,4,67,9.75);
	Vehicle v7=new Vehicle("XNW422", "Make7","Model7",2011,2,62,9.85);
	Vehicle v8=new Vehicle("UWG309", "Make8","Model8",2010,4,63,9.95);
	Vehicle v9=new Vehicle("QVM285", "Make9","Model9",2009,2,64,9.15);
	Vehicle v10=new Vehicle("BBV995", "Make10","Model10",2008,4,62,9.05);


	private HashMap<String,Vehicle> vehicleMap = new HashMap<String,Vehicle>();
	public ArrayList<Vehicle> list = new ArrayList<Vehicle>();{
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		list.add(v7);
		list.add(v8);
		list.add(v9);
		list.add(v10);		
		vehicleMap.put(v1.license,v1);
		vehicleMap.put(v2.license,v2);
		vehicleMap.put(v3.license,v3);
		vehicleMap.put(v4.license,v4);
		vehicleMap.put(v5.license,v5);
		vehicleMap.put(v6.license,v6);
		vehicleMap.put(v7.license,v7);
		vehicleMap.put(v8.license,v8);
		vehicleMap.put(v9.license,v9);
		vehicleMap.put(v10.license,v10);	
	}
	

	public void addVehicle(Vehicle e) {
		list.add(e);
		vehicleMap.put(e.license,e);
		System.out.println("The vehicle "+e.make+" has been added to the list.");
		
	}
	
	public void removeVehicle(String e){
		
		for(int i = 0 , len= list.size();i<len;++i){  
			if(list.get(i).make.equals(e)){  
				list.remove(i);  
				--len;  
				--i;
			}
		}
		System.out.println("The vehicle "+e+" has been removed from the list.");
	}
	
	public void getVehicle(){
		for(int i = 0 , len= list.size();i<len;++i){
			System.out.println(list.get(i).display());

		}
	}
	
	public void getMap(String n){
		if (vehicleMap.get(n)==null) System.out.println("Didn't find the license.");
		else System.out.println(vehicleMap.get(n).display());	
	}
	
	public void sortList(){

		ArrayList<String> newlist = new ArrayList<String>();
		for (int i =0 ; i<list.size();i++){
			newlist.add(list.get(i).license);
		}
		
		Collections.sort(newlist);
		for (int i =0 ; i<newlist.size();i++){
			String str = newlist.get(i);			
			System.out.println(vehicleMap.get(str).display());
		}
		
		System.out.println("Sorted by the lincense: "+newlist);


	}
	
	
	
	
}

