package edu.neu.csye6200.registry;

/**
 * 
 * @author (huizhe wang)
 * ID: (001614841)
 *
 */

public class TruckVehicle extends Vehicle{
 public double height;
 public double width;
 public double length;
 
 TruckVehicle(double h, double w, double l,int p, int f, String Make, String Model, String License, int m, double KPL){
	 super(p,f,Make,Model,License,m,KPL);
	 height=h;
	 width=w;
	 length=l;
 }
 
 public double area(){
		return width*length*height;
	}
	
	@Override
	public String display() {
		String result=super.display();
		System.out.println(result);
		System.out.println("Height: " + height);
		System.out.println("Width: " + width);
		System.out.println("Length: " + length);
		System.out.println("Area: " + width*length*height);
		return "";
	}
 
 
 public static void main(String[] args) {
		// Create an instance of the class, and call the constructor method
		run(); 
	}
 
 public static void run(){
	 TruckVehicle truck1 = new TruckVehicle(1.5,1.5,2.0,4,11,"BMW","i8","VBG 984",2014,47.5);
	 truck1.display();	 
 }
}
