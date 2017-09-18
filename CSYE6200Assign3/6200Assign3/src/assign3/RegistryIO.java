package assign3;

/**
 * 
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class RegistryIO {
	public void save(VehicleRegistry lt, String filename) {
		try {
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
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public void load(String filePath) {
		try {
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
			System.out.println(e.getMessage());
		}
	}
}
