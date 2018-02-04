package ComputingClub;

import java.util.ArrayList;
import java.util.Arrays;

public class EnclosureWorks1 {

	public static void main(String[] args) {
//				secondMain("[2+3*8-3)]+6");
//				secondMain("[2+3*8–3)]+6");
//				secondMain("([2–5]+6");
//				secondMain("[(5+5–2]*5");
//				secondMain("13–[(6+18)/3*22");
//				secondMain("[4/(12–8/4*25]");
				
			
			String s = "[(5+5-2]*5";
			System.out.println(s.compareTo("[(5+5-2]*5"));
				secondMain(s);
//				secondMain("[(5+5-2]*5");

	}

	public static void secondMain(String input) {
		//Find the Missing item in the array
		char[] target = findMissing(input);
		char unpaired = target[0];
		char unpairedIndex = target[1];
		System.out.println("Main Missing Index is: "+ (int)target[1]);

		if(unpaired == '(' || unpaired == '[') {
			String s = input.substring(0,unpairedIndex);
			System.out.println("LENGTH IS"+s.length());
			input = input.substring(unpairedIndex, input.length());
			System.out.println("WHAT IS LEFT IS: " + input);
			String[] valueReturned = closedEliminatorLeftOpen(input);

			input = valueReturned[0];
			System.out.println("WHAT IS LEFT IS: " + input);
			ArrayList<Integer> answer = finalDeterminorLeftOpen(input);
			System.out.println("FINAL ANSWER");
			for(int i = 0; i < answer.size(); i++) {
				answer.set(i, answer.get(i)+s.length());	 //THIS LINE IS CHANGEDInteger.parseInt(valueReturned[1])
				if(answer.get(i) == -1) {
					answer.set(i,0);
				}
				answer.set(i,answer.get(i)+1);
				System.out.println(answer.get(i));
			}


		}else if(unpaired == ')' || unpaired == ']') {
			input = input.substring(0, unpairedIndex + 1);
			System.out.println("WHAT IS LEFT IS" + unpairedIndex);
			String[] valueReturned = closedEliminator(input);
			input = valueReturned[0];

			ArrayList<Integer> answer = finalDeterminor(input);
			System.out.println("FINAL ANSWER");
			for(int i = 0; i < answer.size(); i++) {
				answer.set(i, answer.get(i)+Integer.parseInt(valueReturned[1]));
				if(answer.get(i) == -1) {
					answer.set(i,0);
				}
				answer.set(i,answer.get(i)+1);
				System.out.println(answer.get(i));
			}

		}

	}



	public static ArrayList<Integer> finalDeterminorLeftOpen(String input) {

		ArrayList<Integer> solutions = new ArrayList<Integer>();
		int validStartor = validStartor2(input);

		for(int i = 1; i < input.length(); i++) {
			System.out.println("I is "+ i + "  Comparing:" + input.charAt(i));	
			if(input.charAt(i) == '(') {
				int stackCount = 0;
				System.out.println("Going in"+input.substring(i,i+1));
				for(int z = i+1; z < input.length(); z++) {
					System.out.println("Z is "+ z + "  Comparing:" + input.charAt(z));
					if(input.charAt(z) == ')' && stackCount == 0) {
						i = z+1;
						System.out.println("WILL GO THROUGH " + input.substring(0, i));
						System.out.println("Solution is" + (z));
						solutions.add(z+1);
						break;
					}else if(input.charAt(z) == '(' || input.charAt(z) == '['){
						System.out.println("Executed open" +  input.charAt(z) + "Number is"+ z);
						stackCount++;
					}if(input.charAt(z) == ')' || input.charAt(z) == ']') {
						System.out.println("Executed closed" +  input.charAt(z) + "Number is"+ z);
						stackCount--;
					}
				}
			}else if(input.charAt(i) == '[') { //NEED TO CHECK/FIX
				int stackCount = 0;
				System.out.println("Going in"+input.substring(0,i));
				for(int z = i+1; z < input.length(); z++) {
					System.out.println("Z is "+ z + "  Comparing:" + input.charAt(z));
					if(input.charAt(z) == ']' && stackCount == 0) {
						i = z+1;
						System.out.println("WILL GO THROUGH " + input.substring(0, i));
						System.out.println("Solution is" + (z));
						solutions.add(z+1);
						break;
					}else if(input.charAt(z) == '(' || input.charAt(z) == '['){
						System.out.println("Executed open" +  input.charAt(z) + "Number is"+ z);
						stackCount++;
					}if(input.charAt(z) == ')' || input.charAt(z) == ']') {
						System.out.println("Executed open" +  input.charAt(z) + "Number is"+ z);
						stackCount--;
					}
				}
			}else if(i > input.length()-1) {
				break;
			}else if(operationCheckor(input.charAt(i))) {
				System.out.println("EXECUTED OPERATOR AT" + input.charAt(i));
				continue;
			}else {
								System.out.println("IN HERE");
//								System.out.println("    CONDITION "+ (operationCheckor(input.charAt(i+1))));
				if(!operationCheckor(input.charAt(i)) && i >= validStartor){
					if(i != input.length()-1 && operationCheckor(input.charAt(i+1))){
						System.out.println("			SOLUTION AFTER" + (i+1));
						solutions.add(i+1);
					}if(i == input.length()-1) {
						System.out.println("			SOLUTION AFTER" + (i+1));
						solutions.add(i+1);
					}
				}
			}

		}

		for(int i = 0; i < solutions.size(); i++) {
			System.out.println(solutions.get(i));
		}
		return solutions;
	}

	public static int validStartor2(String input) {//IMPLEMENT THIS WITH OTHER ONE TOO
		int x = 2;
		while(true) {
			if(!operationCheckor(input.charAt(x+1))) {
				System.out.println("RETURENED"+x);
				return x;
			}
			x++;
		}

	}

	public static String[] closedEliminatorLeftOpen(String input) {
		char[] stack = new char[input.length()];
		int stackCounter = 0;
		int timesCut = 0;
//				System.out.println("Going IN:"+ input);
		for(int i = 1; i <input.length(); i++) { 
//						System.out.println("CHECK:"+input.charAt(i));
			if((input.charAt(i) == ')' || input.charAt(i)== ']') && stackCounter == 0) {
				input = input.substring(0,i);
//								System.out.println("New String is:" + input);
				timesCut++;
				break;
			}else if(input.charAt(i) == '(' || input.charAt(i) == '['){
				stack[stackCounter] = input.charAt(i);
				stackCounter++;
//								System.out.print("OPEN INITIATED");
								arrayPrintor(stack);
			}else if(input.charAt(i) == ')' || input.charAt(i) == ')') {
				stack[stackCounter-1] = 0;
				stackCounter--;
//								System.out.println("CLOSE INITIATED HERE");
				
				
			}
		}
//				System.out.println("CUT INPUT IS: "+input);
		String[] temp = {input,Integer.toString(timesCut)};
		return temp;

	}


	public static ArrayList<Integer> finalDeterminor(String input) {

		ArrayList<Integer> solutions = new ArrayList<Integer>();
		input = input.substring(0, input.length()-1);
		int validStartor = validStartor(input);

		for(int i = input.length()-1; i > -1; i--) {
			System.out.println("I is "+ i + "  Comparing:" + input.charAt(i));	
			//			/*
			if(input.charAt(i) == ')') {
				int stackCount = 0;
				System.out.println("Going in"+input.substring(0,i));
				for(int z = i-1; z > -1; z--) {
					//					System.out.println("Z is "+ z + "  Comparing:" + input.charAt(z));
					if(input.charAt(z) == '(' && stackCount == 0) {
						i = z-1;
						System.out.println("WILL GO THROUGH " + input.substring(0, i+1));
						System.out.println("Solution is" + (z-1));
						solutions.add(z-1);
						break;
					}else if(input.charAt(z) == ')' || input.charAt(z) == ']'){
						System.out.println("Executed closed" +  input.charAt(z) + "Number is"+ z);
						stackCount++;
					}if(input.charAt(z) == '(' || input.charAt(z) == '[') {
						System.out.println("Executed open" +  input.charAt(z) + "Number is"+ z);
						stackCount--;
					}
				}
			}else if(input.charAt(i) == ']') {
				int stackCount = 0;
				System.out.println("Going in"+input.substring(0,i));
				for(int z = i-1; z > -1; z--) {
					System.out.println("Z is "+ z + "  Comparing:" + input.charAt(z));
					if(input.charAt(z) == '[' && stackCount == 0) {
						i = z-1;
						System.out.println("WILL GO THROUGH " + input.substring(0, i+1));
						System.out.println("Solution is" + (z-1));
						solutions.add(z-1);
						break;
					}else if(input.charAt(z) == ')' || input.charAt(z) == ']'){
						System.out.println("Executed closed" +  input.charAt(z) + "Number is"+ z);
						stackCount++;
					}if(input.charAt(z) == '(' || input.charAt(z) == '[') {
						System.out.println("Executed open" +  input.charAt(z) + "Number is"+ z);
						stackCount--;
					}
				}
			}
			if(i < 0) {
				break;
			}
			//			*/
			if(operationCheckor(input.charAt(i))) {
				System.out.println("EXECUTED OPERATOR AT" + input.charAt(i));
				continue;
			}else {
				if(!operationCheckor(input.charAt(i)) && i <= validStartor){
					System.out.println("			SOLUTION BEFORE" + i);
					solutions.add(i);
				}
			}

		}

		for(int i = 0; i < solutions.size(); i++) {
			System.out.println(solutions.get(i));
		}
		return solutions;
	}

	public static int validStartor(String input) {
		
		if(!operationCheckor(input.charAt(input.length()-2))) {
			return input.length()-2;
		}else if(!operationCheckor(input.charAt(input.length()-3))){
			return input.length()-3;
		}
		return 0;
	}

	public static boolean operationCheckor(char i) {
		if(i == '*' || i == '-' || i == '/' || i == '+') {
			return true;
		}else return false;
	}

	public static String[] closedEliminator(String input) {
		char[] stack = new char[input.length()];
		int stackCounter = 0;
		int timesCut = 0;
		System.out.println("Going IN:"+ input);
		for(int i = input.length()-2; i > -1; i--) { //CHECK THE -2
			System.out.println("CHECK:"+input.charAt(i));
			if((input.charAt(i) == '(' || input.charAt(i)== '[') && stackCounter == 0) {
				input = input.substring(i+1,input.length());
				System.out.println("New String is:" + input);
				timesCut++;
				break;
			}else if(input.charAt(i) == ')' || input.charAt(i) == ']'){
				stack[stackCounter] = input.charAt(i);
				stackCounter++;
				System.out.print("CLOSED INITIATED");
				arrayPrintor(stack);
			}else if(input.charAt(i) == '(' || input.charAt(i) == '[') {
				stack[stackCounter-1] = 0;
				stackCounter--;
				System.out.print("OPEN INITIATED");
				arrayPrintor(stack);
			}
		}
		System.out.println("CUT INPUT IS: "+input);
		String[] temp = {input,Integer.toString(timesCut)};
		return temp;

	}

	public static char[] findMissing(String input) {
		char[] openItems = new char[input.length()]; 
		int[] openIndexItems = new int[input.length()]; 
		int openIndex = 0;
		char[] closedItems = new char[input.length()];
		int[] closedIndexItems = new int[input.length()]; 
		int closedIndex = 0;
		//creates the appropriate array with only brackets and parenthesis
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(' || input.charAt(i) == '[') {
				openItems[openIndex] = input.charAt(i); 
				openIndexItems[openIndex] = i;
				openIndex++;
			}else if(input.charAt(i) == ')' || input.charAt(i) == ']') {
				closedItems[closedIndex] = input.charAt(i); 
				closedIndexItems[closedIndex] = i;
				closedIndex++;
			}
		}	
		//Getting rid of items where pair is found
		for(int z = 0; z < openIndex; z++) {
			for(int i = 0; i < closedIndex; i++) {
				if(openItems[z] == '[' && closedItems[i] == ']') {
					//					System.out.println("Found:" + openItems[z] + " " + closedItems[i]);
					openItems[z] = '=';
					closedItems[i] = '=';
				}if(openItems[z] == '(' && closedItems[i] == ')') {
					//					System.out.println("Found:" + closedItems[z]);
					openItems[z] = '=';
					closedItems[i] = '=';
				}

			}

		}

		for(int z = 0; z < openIndex; z++) {
			if(openItems[z] != '=') {
				System.out.println("Unpaired Found: " + openItems[z]);
				System.out.println("Index is:"+ openIndexItems[z]);
				char[] temp = {openItems[z],(char)openIndexItems[z]};
				return temp;
			}
		}
		for(int i = 0; i < closedIndex; i++) {
			if(closedItems[i] != '=') {
				System.out.println("Unpaired Found: " + closedItems[i]);

				char[] temp = {closedItems[i],(char)closedIndexItems[i]};
				return temp;
			}
		}
		return null;

	}
	public static void arrayPrintor(char[] input) {
		System.out.println(Arrays.toString(input));
	}

}
