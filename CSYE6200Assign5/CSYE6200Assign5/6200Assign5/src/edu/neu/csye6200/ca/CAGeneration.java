package edu.neu.csye6200.ca;

import java.util.ArrayList;



public class CAGeneration {
	
	/**
	 * 
	 */
	private ArrayList<CACell> CACellList = new ArrayList<CACell>();
	

	public CACell get_CACellList(int CACell) {
		return CACellList.get(CACell);
	}

	public void set_CACellList(int index, CACell CACell) {
		CACellList.set(index, CACell);
	}
	
	public void Add_CACellList(CACell CACell) {
		CACellList.add(CACell);
	}
	
	public ArrayList<CACell> CACellList() {
		return CACellList;
	}


	private int num;
	
	CACell CACell=null;
	
	public CAGeneration(int num){
		this.num=num;
		for (int i = 0; i < num; i++) {
			if(i==num/2){
				CACell = new CACell(125,125,125);
			    CACellList.add(CACell);
			}else{
				CACell = new CACell(255,255,255);
				CACellList.add(CACell);
			}
		}
	}	
	
		
}



	
	
	


	