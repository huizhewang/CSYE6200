package edu.neu.csye6200.ca;

public class CAGeneration {

	private int num;
	private int []CellA;
	private int []CellB;

	public CAGeneration(int num){
		
		CellA =new int[num];
		CellB =new int[num];
		this.num=num;
		
		for (int i = 0; i < num; i++) {
			CellA[i] = 0;
		}

		CellA[num / 2] = 1;
		
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int[] getCellA() {
		return CellA;
	}

	public void setCellA(int[] cellA) {
		CellA = cellA;
	}

	public int[] getCellB() {
		return CellB;
	}

	public void setCellB(int[] cellB) {
		CellB = cellB;
	}
	
	}
