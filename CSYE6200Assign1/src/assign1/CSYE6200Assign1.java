package assign1;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * A starter file for implementing CSYE 6200 Assignment 1 <br>
 * Note: the package is 'assign1' so your code should be in source folder: src\assign1
 * Filename: CSYE6200Assign1.java <br>
 * 
 * NUID: (001614841) <br>
 * @author (Huizhe Wang)
 */
class CSYE6200Assign1 {

	/**
	 * Your program starts with this method call
	 */
	public static void main(String args[]) throws java.io.IOException {
		// Create an instance of the class, and call the constructor method
		CSYE6200Assign1 prog1 = new CSYE6200Assign1();
		prog1.run(); // call the run method
		// We're done. The program will exit.
	}

	/**
	 * Constructor
	 */
	public CSYE6200Assign1() {
		// After a 'new' call the constructor is executed first - for now, nothing happens
	}
	/**
	 * Perform all of the user operations
	 */
	public void run() throws java.io.IOException {
		char inChar = ' ';
		char ignore;
		Scanner sc=new Scanner(System.in);
		ArrayList<String> history = new ArrayList<String>();
		do{
            System.out.println("Enter choice (1,2,3), or \'q\' to quit, then press <enter>.");
            
            String inPut = sc.next();
            history.add(inPut);

            if (inPut.equals ("hwang")) {
                System.out.println("Password accepted!");
                continue;
            	}
            if (inPut.equals("q")){
            	inChar ='q';
                break;
            	}
            if (inPut.length() == 1){
                inChar = inPut.charAt(0);

			switch (inChar) {
			case '1':
				System.out.println("You selected option 1");
				int i=1;
				int sum=0;
				for(;i<=9;i++){	
				System.out.println(i+"*"+i+"*"+i+"="+i*i*i);
			    sum=sum+i*i*i;
				System.out.println("the sum of the displayed cubed values: from 1 to "+i+" is "+sum);
				}
				break;
			case '2':
				System.out.println("You selected option 2");
				System.out.println("please input the key value:");
				int a=(int)(char) System.in.read();
				do{
					ignore=(char)System.in.read();
				}
				while(ignore !='\n');	

				System.out.println("the input key value is "+a);
				break;
			case '3':
				System.out.println("You selected option 3");
				 for (int b = 0 ; b < 3 - history.size(); b++){
                     System.out.println("*");
                 }

                 int b = history.size() - 3;
                 if (b < 0)
                     b = 0;
                 for (; b < history.size(); b++){
                     System.out.println(history.get(b));
                 }
				break; 
			case '\n':
				break;
			case 'q':
			    break;
			default:
				System.out.println("Invalid selection: " + inChar);
				break; 
			}
			// react to input and take appropriate action

			// check for password matching
			// if (isPassCodeTyped(inchar)) 
			//    ...do something...

		}
        if(inPut.length()!=1) System.out.println("Invalid input: "+inPut);
		}while (inChar != 'q'); // Exit on quit
		System.out.println("Quiting...");
		sc.close();
	}
}

	/*
	 * Has the passcode been typed?
	 * @return true if the password sequence has been typed
	 */
	//private boolean isPassCodeTyped(char c) {
		// Check this keypress, and also check prior keypress values

		// example passcode for Mark Munson is "mmuns"

		//return false;