package assign3;

/**
 * 
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */

import java.util.ArrayList;
//import java.util.List;
import java.util.HashMap;



public class VehicleRegistry {
	public static ArrayList<Vehicle> list = new ArrayList<Vehicle>();
	private HashMap<String, Vehicle> vehicleHashMap = new HashMap<String, Vehicle>();
	
	Vehicle v1=new Vehicle(4,11,"Benz","R8","VBG 666",2014,47.5);
	Vehicle v2=new Vehicle(4,11,"Maserati","GranCabrio","KDE 888",2014,47.5);
	TruckVehicle truck = new TruckVehicle(1.5,1.5,2.0,4,11,"BMW","i8","VBG 984",2014,47.5);


	public void testAdd(){
		
		list.add(v1);
		Vehicle temp=(Vehicle)list.get(0);	
		list.add(v2);
		Vehicle temp1=(Vehicle)list.get(1);	
		list.add(truck);
		Vehicle temp2=(Vehicle)list.get(2);	
		System.out.println("add vehicle 1");
		System.out.println(temp.display());
		System.out.println("");
		System.out.println("add vehicle 2");
		System.out.println(temp1.display());
		System.out.println("");
		System.out.println("add Truck Vehicle");
		System.out.println(temp2.display());
		System.out.println("");
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

	public void addVehicle(Vehicle vehicle){
        list.add(vehicle);
        vehicleHashMap.put(vehicle.license, vehicle);
    }
	
	public Vehicle getVehicleByLicense(String license){
		vehicleHashMap.put("VBG666",v1 );
		vehicleHashMap.put("KDE888",v2 );
		return vehicleHashMap.get(license);
    }
	
}
