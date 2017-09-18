package edu.neu.csye6200.registry;


/**
 * 
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Logger;



public class VehicleRegistry {
	
	//Log information messages 
	public static final Logger LOGGER = Logger.getLogger(Vehicle.class.getName());
	
	private static VehicleRegistry instance=null;
	
	public VehicleRegistry(){
		LOGGER.info("Logger Name: "+LOGGER.getName());
	}
	
	public static VehicleRegistry instance(){
		if(instance==null){
			instance=new VehicleRegistry();
		}
			return (instance);
	}
	
	public static ArrayList<Vehicle> list = new ArrayList<Vehicle>();
	public ArrayList<String>newlist=new ArrayList<String>();
	private HashMap<String, Vehicle> vehicleHashMap = new HashMap<String, Vehicle>();
	
	Vehicle v1=new Vehicle(4,11,"Benz","R8","VBG666",2014,47.5);
	Vehicle v2=new Vehicle(4,11,"Maserati","GranCabrio","KDE888",2014,47.5);
	Vehicle v3=new Vehicle(4,11,"BMW","i8","CBC668",2014,47.5);
	Vehicle v4=new Vehicle(4,11,"BMW","mini","GGG168",2014,47.5);
	Vehicle v5=new Vehicle(4,11,"AUDI","A6","EBF789",2014,47.5);
	Vehicle v6=new Vehicle(2,11,"Ferrari","California","SSR123",2009,47.5);
	Vehicle v7=new Vehicle(4,11,"Renault","Laguna","BCD959",2002,47.5);
	Vehicle v8=new Vehicle(4,11,"Bentley","EXP 9F","MBC353",2014,47.5);
	Vehicle v9=new Vehicle(4,11,"Passat","VW","MMM222",2017,47.5);
	Vehicle v0=new Vehicle(4,11,"VOLVO","XC90","LLL777",2014,47.5);
	
	TruckVehicle truck = new TruckVehicle(1.5,1.5,2.0,4,11,"BMW","i8","VBG984",2014,47.5);


	public void testAdd(){
		
    	list.add(v1);
//		Vehicle temp=(Vehicle)list.get(0);	
		list.add(v2);
//		Vehicle temp1=(Vehicle)list.get(1);	
		list.add(truck);
//		Vehicle temp2=(Vehicle)list.get(2);	
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		list.add(v7);
		list.add(v8);
		list.add(v9);
		list.add(v0);
//		System.out.println("add vehicle 1");
//		System.out.println(temp.display());
//		System.out.println("");
//		System.out.println("add vehicle 2");
//		System.out.println(temp1.display());
//		System.out.println("");
//		System.out.println("add Truck Vehicle");
//		System.out.println(temp2.display());
//		System.out.println("");
	}
	
	public void testGet(){
		int size =list.size();
		System.out.println("you can get vehicle");
		for(int i=0;i<size;i++){
			Vehicle temp1=(Vehicle)list.get(i);
			System.out.println(temp1.display());
			System.out.println("");
			}
	}
	
	public void testRemove(){
		list.remove(1);
		System.out.println("remove vehicle 2 successfully!!!");
	}
	
	public void testForEach(){
		System.out.println("print the contents in the list now");
		for(Object obj:list){
			Vehicle temp3=(Vehicle)obj;
			System.out.println(temp3.display());
			System.out.println("");
		}
	}

    public void testList(){
    		vehicleHashMap.put(v1.license,v1);
        	vehicleHashMap.put(v2.license,v2);
    		vehicleHashMap.put("VBG984",truck);
    		vehicleHashMap.put("CBC668",v3);
    	    vehicleHashMap.put("GGG168",v4 );
    		vehicleHashMap.put("EBF789",v5 );
    		vehicleHashMap.put("SSR123",v6 );
    		vehicleHashMap.put("BCD959",v7 );
    		vehicleHashMap.put("MBC353",v8 );
    		vehicleHashMap.put("MMM222",v9 );
    		vehicleHashMap.put("LLL777",v0 );
    		
	for(int i=0;i<list.size();i++){
		newlist.add(list.get(i).license);
	}
	Collections.sort(newlist);
	System.out.println("vehicles are sorted by license:");
	for(int i=0;i<newlist.size();i++){
		String str=newlist.get(i);	
		System.out.println("");
		System.out.println(vehicleHashMap.get(str).display());	
	}
	System.out.println("You can use the next line to check them");
	System.out.println(newlist);
	}
}

