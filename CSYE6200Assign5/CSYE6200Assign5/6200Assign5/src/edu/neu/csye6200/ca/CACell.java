package edu.neu.csye6200.ca;

public class CACell {
	
	 private int Red;
	 private int Green;
	 private int Blue;
	 
	 public int getRed() {
		return Red;
	}


	public void setRed(int red) {
		Red = red;
	}


	public int getGreen() {
		return Green;
	}


	public void setGreen(int green) {
		Green = green;
	}


	public int getBlue() {
		return Blue;
	}


	public void setBlue(int blue) {
		Blue = blue;
	}
	 
	 public CACell(int R, int G, int B){
		 this.Red=R;
		 this.Green=G;
		 this.Blue=B;

	}

}