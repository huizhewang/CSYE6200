package edu.neu.csye6200.registry;

import java.io.Serializable;

/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author (Pengyu Chen)
 * ID: (001217545)
 *
 */
public class Vehicle implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int passengers;
   int fuelCap;
   int year;
   double kpl;
   String make,model,license;
   
   double range() { 
	   return fuelCap * kpl;
   }
   
   Vehicle(String li, String ma, String mo, int y, int p, int f, double k) {
	   make = ma;
	   model = mo;
	   year = y;
	   passengers = p;
	   fuelCap = f;
	   kpl = k;
	   license = li;
   }
   
    String display(){
	   return (make+"\nModel:"+model+"\nModel Year:"+year+"\nThe car can carry "+ passengers+" passengers "+"\nThe car can run "+range()+" km in city.\n"+"Lincese Plate: "+license+"\n");
   }
}
