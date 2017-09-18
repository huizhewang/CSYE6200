package assign3;

/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */
public class Vehicle {
   int passengers;
   int fuelCap;
   String make;
   String model;
   String license;
   int ModelYear;
   //Note-in the lecture, we switched from using Miles Per Gallon (MPG) to using Kilometers Per Liter (KPL).
   double kpl; // <== so this should be 'kpl', not 'mpg'
   Vehicle(int p, int f, String Make, String Model, String License, int m, double KPL){
	   passengers=p;
	   fuelCap=f;
	   make=Make;
	   model=Model;
	   license=License;
	   ModelYear=m;
	   kpl=KPL;
   }

   public Vehicle(){
	   
   }
 String display(){
	   System.out.println ("Make: " + make);
	   System.out.println ("Model: " + model);
	   System.out.println("License: " + license);
	   System.out.println("Passengers: " + passengers);
	   System.out.println("Fuelcap: " + fuelCap);
	   System.out.println("Model Year: " + ModelYear);
	   System.out.println("Kilometers per liter: " + kpl);
	   return ("Range: "+(int)(kpl/0.43*fuelCap));	  
   }

public int getPassengers() {
	return passengers;
}

public void setPassengers(int passengers) {
	this.passengers = passengers;
}

public int getFuelCap() {
	return fuelCap;
}

public void setFuelCap(int fuelCap) {
	this.fuelCap = fuelCap;
}

public String getMake() {
	return make;
}

public void setMake(String make) {
	this.make = make;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getLicense() {
	return license;
}

public void setLicense(String license) {
	this.license = license;
}

public int getModelYear() {
	return ModelYear;
}

public void setModelYear(int modelYear) {
	ModelYear = modelYear;
}

public double getKpl() {
	return kpl;
}

public void setKpl(double kpl) {
	this.kpl = kpl;
}

  
}
