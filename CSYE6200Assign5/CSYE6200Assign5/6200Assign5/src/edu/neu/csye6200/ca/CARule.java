package edu.neu.csye6200.ca;

import java.awt.Color;

public class CARule {

	private int rule = 0;

	private Color a = null;
	private Color b = null;
	private Color c = null;
	private Color d = null;

	CACell cell = new CACell(125, 125, 125);

	public CARule(int num) {
		this.rule = num;
	}

	public CACell ruleList(CACell cell_1, CACell cell_2, CACell cell_3) {

		switch (rule) {
		case 1: {
			d = new Color((int) ((cell_1.getRed() + cell_2.getRed() + cell_3.getRed()) % 255),
					(int) ((cell_1.getGreen() + cell_2.getGreen() + cell_3.getGreen()) % 255),
					(int) ((cell_1.getBlue() + cell_2.getBlue() + cell_3.getBlue()) % 255));

			cell.setRed(d.getRed());
			cell.setGreen(d.getGreen());
			cell.setBlue(d.getBlue());

		}
			break;
			
		case 2: {
			a = new Color(cell_1.getRed() + cell_1.getGreen() + cell_1.getBlue());
			b = new Color(cell_2.getRed() + cell_2.getGreen() + cell_2.getBlue());
			c = new Color(cell_3.getRed() + cell_3.getGreen() + cell_3.getBlue());

			d = new Color((int) ((a.getRed() + b.getRed() + c.getRed()) % 255),
					(int) ((a.getGreen() + b.getGreen() + c.getGreen()) % 255),
					(int) ((a.getBlue() + b.getBlue() + c.getBlue()) % 255));

			cell.setRed(d.getRed());
			cell.setGreen(d.getGreen());
			cell.setBlue(d.getBlue());
		}
			break;
			
		case 3: {
			boolean cell1_0n = true;
			if ((cell_1.getRed() == 255) && (cell_1.getGreen() == 255) && (cell_1.getBlue() == 255)) {
				cell1_0n = false;
			}
			boolean cell2_0n = true;
			if ((cell_2.getRed() == 255) && (cell_2.getGreen() == 255) && (cell_2.getBlue() == 255)) {
				cell2_0n = false;
			}
			boolean cell3_0n = true;
			if ((cell_3.getRed() == 255) && (cell_3.getGreen() == 255) && (cell_3.getBlue() == 255)) {
				cell3_0n = false;
			}

			// int[] ruleset = {0,1,0,1,1,0,1,0};
			if ((cell1_0n==false) && (cell2_0n==false) && (cell3_0n==false)) {
				cell.setRed(255);
				cell.setGreen(255);
				cell.setBlue(255);
			}else if ((cell1_0n==false) && (cell2_0n==false) && (cell3_0n==true)) {
				cell.setRed(5);
				cell.setGreen(0);
				cell.setBlue(125);
			} else if ((cell1_0n==false) && (cell2_0n==true) && (cell3_0n==false)) {
				cell.setRed(255);
				cell.setGreen(255);
				cell.setBlue(255);
			} else if ((cell1_0n==false) && (cell2_0n==true) && (cell3_0n==true)) {
				cell.setRed(125);
				cell.setGreen(125);
				cell.setBlue(125);
			} else if ((cell1_0n==true) && (cell2_0n==false) && (cell3_0n==false)) {
				cell.setRed(255);
				cell.setGreen(0);
				cell.setBlue(125);
			} else if ((cell1_0n==true) && (cell2_0n==false) && (cell3_0n==true)) {
				cell.setRed(255);
				cell.setGreen(255);
				cell.setBlue(255);
			} else if ((cell1_0n==true) && (cell2_0n==true) && (cell3_0n==false)) {
				cell.setRed(125);
				cell.setGreen(125);
				cell.setBlue(125);
			} else if ((cell1_0n==true) && (cell2_0n==true) && (cell3_0n==true)) {
				cell.setRed(255);
				cell.setGreen(255);
				cell.setBlue(255);
			}
			
		}
			break;
			
		case 4: {			
			int Red = (cell_1.getRed() + cell_2.getRed() + cell_3.getRed()) % 255;
			int Green = (cell_1.getGreen() + cell_2.getGreen() + cell_3.getGreen()) % 255;
			int Blue = (cell_1.getBlue() + cell_2.getBlue() + cell_3.getBlue()) % 255;
			if (Red > cell_1.getRed()) {
				Red = (int) (cell_1.getRed() * Math.random() / 2);
			}
			if (Green > cell_2.getGreen()) {
				Green = (int) (cell_2.getGreen() * Math.random() / 2);
			}
			if (Blue > cell_3.getBlue()) {
				Blue = (int) (cell_3.getBlue() * Math.random() / 2);
			}
			d = new Color((int) (Red), (int) (Green), (int) (Blue));
			cell.setRed(d.getRed());
			cell.setGreen(d.getGreen());
			cell.setBlue(d.getBlue());
			

		}
			break;
		}
		return cell;

	}
}
