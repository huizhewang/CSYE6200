package edu.neu.csye6200.ca;


public class CAGenerationSet {  
  

	public void display(){
		
		 int time =30;
		 
		 CAGeneration cell=new CAGeneration(64);

	     CARule rule=new CARule();
		
		 String str="";

        for(int t=0;t<time;t++){

        for(int i=0;i<cell.getNum();i++){
  	    cell.getCellB()[i]=rule.rules(cell.getCellA()[(cell.getNum()+i-1)%cell.getNum()],
			                          cell.getCellA()[i],
			                          cell.getCellA()[(i+1)%cell.getNum()]);
	    if(cell.getCellA()[i]==0){
		      str="-";
	        }else{
		    str="|";
	          }
	      System.out.print(str+"");
        }
        System.out.println("");
          for(int j=0;j<cell.getNum();j++){
	       cell.getCellA()[j]=cell.getCellB()[j];
          }
       }
   }
     
     public static void main(String[] args) {
 		// TODO Auto-generated method stub
 	    CAGenerationSet block=new CAGenerationSet();
 		block.display();
 	}

 }
