package edu.neu.csye6200.ca;

import java.util.ArrayList;
import java.util.HashMap;

public class CAGenerationSet {
	private int time;
	private int width;
	private int rule = 0;

	private CACell cell = null;

	private HashMap<String, ArrayList<CACell>> result = new HashMap<String, ArrayList<CACell>>();

	private ArrayList<CACell> nextLine = null;

	public CAGenerationSet(int time, int width) {
		this.time = time;
		this.width = width;
	}

	public void setRule(int num) {
		this.rule = num;
	}

	public HashMap<String, ArrayList<CACell>> Generation() {
		CAGeneration CAG = new CAGeneration(width);
		CARule CAR = new CARule(rule);
		
		for (int t = 0; t < time; t++) {
			nextLine = new ArrayList<CACell>();
			for (int i = 0; i < width; i++) {
				
				if (t == 0) {
					nextLine.add(CAG.get_CACellList(i));
				}
				if (t != 0) {
					CAG.set_CACellList(i,
							CAR.ruleList(result.get(String.valueOf(t - 1)).get((width + i - 1) % width),
									result.get(String.valueOf(t - 1)).get(i),
									result.get(String.valueOf(t - 1)).get((i + 1) % width)));
	
					cell = new CACell(CAG.get_CACellList(i).getRed(), CAG.get_CACellList(i).getGreen(),
							CAG.get_CACellList(i).getBlue());
					
					cell.setRed(CAG.get_CACellList(i).getRed());
					cell.setGreen(CAG.get_CACellList(i).getGreen());
					cell.setBlue(CAG.get_CACellList(i).getBlue());

					nextLine.add(cell);
				}
				
			}
				result.put(String.valueOf(t), nextLine);		
			}
		
		
		for (int counter = 0; counter < result.size(); counter++) {
			for (int counter_1 = 0; counter_1 < result.get(String.valueOf(counter)).size(); counter_1++) {
				System.out.print(result.get(String.valueOf(counter)).get(counter_1).getRed() + ","
						+ result.get(String.valueOf(counter)).get(counter_1).getGreen() + ","
						+ result.get(String.valueOf(counter)).get(counter_1).getBlue() + " ");
			}
			try{								
				Thread.sleep(10);
				System.out.println();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CAGenerationSet block = new CAGenerationSet(30, 65);
		block.Generation();
	}

}
