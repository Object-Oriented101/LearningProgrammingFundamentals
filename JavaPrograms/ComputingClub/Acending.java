package ComputingClub;

//import java.util.ArrayList;
/*
	Name: Prajeet Sangamnerkar
	Problem: Ascending Strings(Senior Division)
 
 */
public class Acending {
	public static void main(String args[]){
		
		sort("314159265");
	}


	public static void sort(String input){

		//--------------------------Variables declared--------------------------------------------------------
		//ArrayList<Integer> dataset = new ArrayList<Integer>(); No need to put numbers in an array list?

		boolean check = false; //terminator for values on the right
		boolean check1 = false;//terminator for values on the left
		int subtract = 1; //used for right numbers, to add a more digits to it by concatenation
		int constant = 1; //used for right numbers, to get rid of the right numbers after correct one is found(becomes a problem when more than one)
		int add = 0; //used for left numbers, to concatenate next number


		//sets left and right to first and last number to begin with
		String left = input.substring(0,1);
		String right = input.substring(input.length()-1,input.length());

		input = input.substring(1,input.length()); //the first number is always one digit, so automatically gets rid of it
		System.out.print(left+" ");//prints the first digit in console

		//---------------------------Main code-------------------------------------------
		while(input.length() != 0){

			//sets default values to make loop work properly after going through again
			check = false;
			check1 = false;
			subtract = 1;
			add = 0;
			constant = 1;

			if(input.length() < left.length()){ //checks to see if impossible to get higher number near the end
				break;
			}

			//--------------------------------------Right Number----------------------------------------

			right = input.substring(input.length()-1,input.length()); //puts right number as last number(changes each time it goes through loop because deletion

			while(!check){

				if(Integer.parseInt(left) < Integer.parseInt(right)){ //correct number is found
					input = input.substring(0, input.length()-constant);
					System.out.print(right+" ");
					check = true;
				}else{ //number is too small, add another digit
					subtract++;
					constant++;
					right = right+input.substring(input.length()-subtract, input.length()-subtract+1);
				}
				//--------------------------------------Compares Number on the right with the new number on the left---------------------------------------

			}

			left = input.substring(0,1); //resets the left number because changes after deletion

			while(!check1){
				if(Integer.parseInt(right) < Integer.parseInt(left)){ //if greater number is found
					System.out.print(left+" ");
					input= input.substring(left.length(), input.length());
					check1 = true;
				}else{ //add another number because current number too small
					add++;
					left =left+input.substring(add,add+1);				
				}
			}
		}
	}

}
