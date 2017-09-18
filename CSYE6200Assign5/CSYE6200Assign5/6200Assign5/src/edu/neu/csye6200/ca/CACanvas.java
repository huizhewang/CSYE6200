package edu.neu.csye6200.ca;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class CACanvas extends JPanel {

	private HashMap<String, ArrayList<CACell>> result = new HashMap<String, ArrayList<CACell>>();
	private ArrayList<CACell> nextLine = new ArrayList<CACell>();
	private int time=-1;
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setResult(HashMap<String, ArrayList<CACell>> result) {
		for(int counter_1=0;counter_1 < result.size(); counter_1++){
			for(int counter_2 = 0; counter_2 < result.get(String.valueOf(counter_1)).size(); counter_2++){
				this.result.put(String.valueOf(counter_1), result.get(String.valueOf(counter_1)));
			}
		}
	}
	
public CACanvas() {
		
	}
	

	public void paint(Graphics g) {
		drawDisplay(g);
	}
	
	public void drawDisplay(Graphics g) {
		//Graphics2D g = (Graphics2D) g;
		super.paintComponent(g);

//		Dimension size = getSize();
//		g2d.setColor(Color.black);
//		g2d.fillRect(0, 0, size.width, size.height);


		for(int counter=0;counter<time+1;counter++){
			nextLine = result.get(String.valueOf(counter));
			for(int counter_1=0;counter_1<nextLine.size();counter_1++){
				if ((int) nextLine.get(counter_1).getRed() == 0
						&& (int) nextLine.get(counter_1).getGreen() == 0
						&& (int) nextLine.get(counter_1).getBlue() == 0) {
					g.setColor(Color.white);
					g.fillRect(counter_1 * 15 + 50, counter * 15, 12, 12);

			   }else{
				   g.setColor(new Color((int) nextLine.get(counter_1).getRed(),
						  (int) nextLine.get(counter_1).getGreen(),
						  (int) nextLine.get(counter_1).getBlue()));
				  g.fillRect(counter_1 * 15 + 50, counter * 15, 12, 12);


			   }
			}
		}

	}
	
//	private void paintCell(Graphics2D g2d, int x, int y, int size, Color color){
//		g2d.setColor(color);
//		g2d.fillRect(x,y,size,size);
//	}
}