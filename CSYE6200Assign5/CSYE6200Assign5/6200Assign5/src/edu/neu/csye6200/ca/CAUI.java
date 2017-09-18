package edu.neu.csye6200.ca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CAUI implements ActionListener{
	
	private Logger log = Logger.getLogger(CAUI.class.getName());
	
	private Thread thread = null;

	private JFrame frame = null;
	
	private JPanel mainPanel = null;
	private JPanel TextPanel = null;
	
	private JButton btnStart = null;
	private JButton btnPause = null;
	private JButton btnContinue = null;
	private JButton btnStop = null;
	private JButton Close = new JButton("Exit");
	
	private CACanvas CACanvas = null;
	private JTextField Cells = null;
	private JTextField Lines = null;
	private JComboBox<String> Rules = null;
	
	private int time=0;
	private int width=0;
	private int rule=0;
	
	private HashMap<String, ArrayList<CACell>> result = new HashMap<String, ArrayList<CACell>>();
	private ArrayList<CACell> nextLine = new ArrayList<CACell>();
	
	public CAUI() {
		log.info("App Started.");
		initGUI();
	}
	
	private void initGUI(){
		frame = new JFrame();
		frame.setTitle("CAUI");

		frame.setSize(1400, 800);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JPanel Panel = new JPanel();
		Panel.add(getTextPanel());
	    Panel.add(getMainPanel());
		frame.add(Panel, BorderLayout.NORTH);

		CACanvas = new CACanvas();
		frame.add(CACanvas, BorderLayout.CENTER);	
		frame.setVisible(true);
	}	


	public JPanel getMainPanel(){
		mainPanel = new JPanel();
//		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new FlowLayout());
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		btnPause = new JButton("Pause");
		btnPause.addActionListener(this);
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(this);
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		Close.addActionListener(this);
		mainPanel.add(btnStart);
		mainPanel.add(btnPause);
		mainPanel.add(btnContinue);
		mainPanel.add(btnStop);
		mainPanel.add(Close);
		return mainPanel;
	}
	
	public JPanel getTextPanel() {
		// TODO Auto-generated method stub
		TextPanel = new JPanel();
//		TextPanel.setBackground(Color.white);
		TextPanel.setLayout(new FlowLayout());
		
		JLabel text1 = new JLabel("Cells");	
		TextPanel.add(text1);
		 Cells = new JTextField(5);
		TextPanel.add(Cells);
		
		JLabel text2 = new JLabel("Lines");
		TextPanel.add(text2);
		 Lines = new JTextField(5);
		TextPanel.add(Lines);
		
		JLabel text3 = new JLabel("Rules");
		TextPanel.add(text3);
		Rules = new JComboBox<String>();
		Rules.addItem("Rule 1");
		Rules.addItem("Rule 2");
		Rules.addItem("Rule 3");
		Rules.addItem("Rule 4");
		Rules.addActionListener(this);
		TextPanel.add(Rules);	
		return TextPanel;
	}
	
	
	private void setResult(HashMap<String, ArrayList<CACell>> result) {
		for (int counter_1 = 0; counter_1< result.size(); counter_1++) {
			for (int counter_2 = 0; counter_2 < result.get(String.valueOf(counter_1)).size(); counter_2++){
				nextLine.add(result.get(String.valueOf(counter_1)).get(counter_2));
			}
			this.result.put(String.valueOf(counter_1), nextLine);
			nextLine = new ArrayList<CACell>();
		}
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		log.info("We received and ActionEvent " + e);
		if(e.getActionCommand().equals("Start")){
			System.out.println("Let's start something.");
			this.width = Integer.parseInt(Cells.getText());
			this.time = Integer.parseInt(Lines.getText());
			if (this.width > 20 && this.time > 15) {
				frame.setSize(this.width * 20, this.time * 20);
			}
			CAGenerationSet CAGS = new CAGenerationSet(time, width);
			CAGS.setRule(rule);
			
			this.setResult(CAGS.Generation());
			CACanvas.setResult(result);

			Runnable run = new Runnable() {
			@Override
			public void run() {

				int counter = 0;
				while (counter < result.size()) {
					for (int counter_1 = 0; counter_1 < result.size(); counter_1++) {
						for (int counter_2 = 0; counter_2 < result.get(String.valueOf(counter_1)).size(); counter_2++) {
							CACanvas.setTime(counter_1);
							CACanvas.repaint();
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
						counter++;
					}
				}
				System.out.println("Thread End");
				}
			};
			thread = new Thread(run);
			thread.start();
				
			}
		if(e.getSource() == btnStop){
			System.out.println("We were called by btnStop");
		    thread.stop();
		}
		
		if(e.getSource() == btnPause){
			System.out.println("We were called by btnPause");
		    thread.suspend();
		}
		if(e.getSource() == btnContinue){
			System.out.println("We were called by btnContinue");
		     thread.resume();
		}
		
		if (e.getSource() == Close) {
			frame.setVisible(false);
			System.exit(0);
		}
		if (e.getSource() == Rules) {
			int command = Rules.getSelectedIndex();
			switch (command) {
			case 0: {
				rule = 1;
			}
				break;
			case 1: {
				rule = 2;
			}
				break;
			case 2: {
				rule = 3;
			}
				break;
		
		case 3: {
			rule = 4;
		}
			break;
		}
		}
	}
}
