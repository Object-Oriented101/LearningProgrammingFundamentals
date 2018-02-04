import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Enclosure {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner mainsc = new Scanner(System.in);
		secondMain(mainsc.next());
		secondMain(mainsc.next());
		secondMain(mainsc.next());
		secondMain(mainsc.next());
		secondMain(mainsc.next());
		mainsc.close();
	}

	public static void secondMain(String input) {
		//Find the Missing item in the array
		char[] target = findMissing(input);
		char unpaired = target[0];
		char unpairedIndex = target[1];

		if(unpaired == '(' || unpaired == '[') {
			String s = input.substring(0,unpairedIndex);
			input = input.substring(unpairedIndex, input.length());
			String[] valueReturned = closedEliminatorLeftOpen(input);

			input = valueReturned[0];
			ArrayList<Integer> answer = finalDeterminorLeftOpen(input);
//			System.out.println(answer.get(0));
			for(int i = 0; i < answer.size(); i++) {
				answer.set(i, answer.get(i)+s.length());	 //THIS LINE IS CHANGEDInteger.parseInt(valueReturned[1])
				if(answer.get(i) == -1) {
					answer.set(i,0);
				}
				answer.set(i,answer.get(i)+1);
				System.out.print(answer.get(i));
				if(i+1 != answer.size()) {
					System.out.print(", ");
				}
			}
			System.out.println();


		}else if(unpaired == ')' || unpaired == ']') {
			input = input.substring(0, unpairedIndex + 1);
			String[] valueReturned = closedEliminator(input);
			input = valueReturned[0];
			ArrayList<Integer> answer = finalDeterminor(input);
			answer.sort(null);
			for(int i = 0; i < answer.size(); i++) {
				answer.set(i, answer.get(i)+Integer.parseInt(valueReturned[1]));
				if(answer.get(i) == -1) {
					answer.set(i,0);
				}
				answer.set(i,answer.get(i)+1);
				System.out.print(answer.get(i));
				if(i+1 != answer.size()) {
					System.out.print(", ");
				}
			}
			System.out.println();

		}

	}
	public static ArrayList<Integer> finalDeterminorLeftOpen(String input) {

		ArrayList<Integer> solutions = new ArrayList<Integer>();
		int validStartor = validStartor2(input);

		for(int i = 1; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				int stackCount = 0;
				for(int z = i+1; z < input.length(); z++) {
					if(input.charAt(z) == ')' && stackCount == 0) {
						i = z+1;
						solutions.add(z+1);
						break;
					}else if(input.charAt(z) == '(' || input.charAt(z) == '['){
						stackCount++;
					}if(input.charAt(z) == ')' || input.charAt(z) == ']') {
						stackCount--;
					}
				}
			}else if(input.charAt(i) == '[') { //NEED TO CHECK/FIX
				int stackCount = 0;
				for(int z = i+1; z < input.length(); z++) {
					if(input.charAt(z) == ']' && stackCount == 0) {
						i = z+1;
						solutions.add(z+1);
						break;
					}else if(input.charAt(z) == '(' || input.charAt(z) == '['){
						stackCount++;
					}if(input.charAt(z) == ')' || input.charAt(z) == ']') {
						stackCount--;
					}
				}
			}else if(i > input.length()-1) {
				break;
			}else if(operationCheckor(input.charAt(i))) {
				continue;
			}else {
				if(!operationCheckor(input.charAt(i)) && i >= validStartor){
					if(i != input.length()-1 && operationCheckor(input.charAt(i+1))){
						solutions.add(i+1);
					}if(i == input.length()-1) {
						solutions.add(i+1);
					}
				}
			}
		}
		return solutions;
	}

	public static int validStartor2(String input) {//IMPLEMENT THIS WITH OTHER ONE TOO
		int x = 2;
		while(true) {
			if(!operationCheckor(input.charAt(x+1))) {
				return x;
			}
			x++;
		}
	}

	public static String[] closedEliminatorLeftOpen(String input) {
		char[] stack = new char[input.length()];
		int stackCounter = 0;
		int timesCut = 0;
		for(int i = 1; i <input.length(); i++) { 
			if((input.charAt(i) == ')' || input.charAt(i)== ']') && stackCounter == 0) {
				input = input.substring(0,i);
				timesCut++;
				break;
			}else if(input.charAt(i) == '(' || input.charAt(i) == '['){
				stack[stackCounter] = input.charAt(i);
				stackCounter++;
			}else if(input.charAt(i) == ')' || input.charAt(i) == ')') {
				stack[stackCounter-1] = 0;
				stackCounter--;
			}
		}
		String[] temp = {input,Integer.toString(timesCut)};
		return temp;
	}


	public static ArrayList<Integer> finalDeterminor(String input) {
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		input = input.substring(0, input.length()-1);
		int validStartor = validStartor(input);

		for(int i = input.length()-1; i > -1; i--) {
			//			/*
			if(input.charAt(i) == ')') {
				int stackCount = 0;
				for(int z = i-1; z > -1; z--) {
					if(input.charAt(z) == '(' && stackCount == 0) {
						i = z-1;
						solutions.add(z-1);
						break;
					}else if(input.charAt(z) == ')' || input.charAt(z) == ']'){
						stackCount++;
					}if(input.charAt(z) == '(' || input.charAt(z) == '[') {
						stackCount--;
					}
				}
			}else if(input.charAt(i) == ']') {
				int stackCount = 0;
				for(int z = i-1; z > -1; z--) {
					if(input.charAt(z) == '[' && stackCount == 0) {
						i = z-1;
						solutions.add(z-1);
						break;
					}else if(input.charAt(z) == ')' || input.charAt(z) == ']'){
						stackCount++;
					}if(input.charAt(z) == '(' || input.charAt(z) == '[') {
						stackCount--;
					}
				}
			}
			if(i < 0) {
				break;
			}
			if(operationCheckor(input.charAt(i))) {
				continue;
			}else {
				if(!operationCheckor(input.charAt(i)) && i <= validStartor){
					solutions.add(i);
				}
			}
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
		for(int i = input.length()-2; i > -1; i--) { //CHECK THE -2
			if((input.charAt(i) == '(' || input.charAt(i)== '[') && stackCounter == 0) {
				input = input.substring(i+1,input.length());
				timesCut++;
				break;
			}else if(input.charAt(i) == ')' || input.charAt(i) == ']'){
				stack[stackCounter] = input.charAt(i);
				stackCounter++;
			}else if(input.charAt(i) == '(' || input.charAt(i) == '[') {
				stack[stackCounter-1] = 0;
				stackCounter--;
			}
		}
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
					openItems[z] = '=';
					closedItems[i] = '=';
				}if(openItems[z] == '(' && closedItems[i] == ')') {
					openItems[z] = '=';
					closedItems[i] = '=';
				}
			}
		}
		for(int z = 0; z < openIndex; z++) {
			if(openItems[z] != '=') {
				char[] temp = {openItems[z],(char)openIndexItems[z]};
				return temp;
			}
		}
		for(int i = 0; i < closedIndex; i++) {
			if(closedItems[i] != '=') {
				char[] temp = {closedItems[i],(char)closedIndexItems[i]};
				return temp;
			}
		}
		return null;
	}

}
