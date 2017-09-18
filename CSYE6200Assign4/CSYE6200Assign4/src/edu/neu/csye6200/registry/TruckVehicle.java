package edu.neu.csye6200.registry;

public class TruckVehicle extends Vehicle {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double height,width,length;
	
	TruckVehicle(double le, double wi, double he,String li, String ma, String mo, int y, int p, int f, double k) {
		super(li, ma, mo, y, p, f, k);
		// TODO Auto-generated constructor stub
		height=he;
		width=wi;
		length=le;			
	}

	public double area(){
		
		return height*width*length;
	}
	
	String display(){
		return (make+"\nModel:"+model+"\nModel Year:"+year+"\nThe car can carry "+ passengers+" passengers "+"\nThe car can run "+range()+" km in city.\n"+ "Truck area: "+area()+"\"");
	}
}
