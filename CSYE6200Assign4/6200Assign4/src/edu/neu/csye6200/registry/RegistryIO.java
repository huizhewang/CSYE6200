package edu.neu.csye6200.registry;

/**
 * 
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class RegistryIO {
	
	//Log information messages for save()
	public final Logger LOGGER = Logger.getLogger(Vehicle.class.getName());
	
	RegistryIO(){
		LOGGER.info("Logger Name（2）: "+RegistryIO.class.getName());
	}
	
	public void save(VehicleRegistry lt, String filename) {
		try {
			LOGGER.info("Log for Save(): "+LOGGER.getName());
			List<Vehicle> vehicles = new ArrayList<Vehicle>();
			vehicles = VehicleRegistry.list;
			PrintStream ps = new PrintStream(new FileOutputStream(filename));
			
			for (Vehicle a : vehicles) {
				ps.println("Make: " + a.make);
				ps.println("Model: " + a.model);
				ps.println("License: " + a.license);
				ps.println("Passengers: " + a.passengers);
				ps.println("Fuelcap: " + a.fuelCap);
				ps.println("Model Year: " + a.ModelYear);
				ps.println("Kilometers per liter: " + a.kpl);
				ps.println("Range: "+(int)(a.kpl/0.43*a.fuelCap));
				if (a instanceof TruckVehicle) {
					ps.println("area: " + ((TruckVehicle) a).area());
				}
				ps.println(" ");
			}
			ps.close();
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block
			 LOGGER.log(Level.SEVERE, "Exception occur for Save()", e);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public void load(String filePath) {
		try {
			LOGGER.info("Log for Load(): "+LOGGER.getName());
			BufferedReader br;
			String read = "";
			File file = new File(filePath);
			FileReader fileread = new FileReader(file);
			br = new BufferedReader(fileread);
			System.out.println("Read information from txt: ");
			while ((read = br.readLine()) != null) {
				System.out.print(read + "\t\n");
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occur for Load()", e);
			System.out.println(e.getMessage());
		}
	}
}
