

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner("communications.txt"); //NEEDS TO BE LINKED TO THE 
		
		int commandLength = sc.nextInt();
		int keeper = 1;
		
		sc.nextLine();//skips the line
		while(keeper != commandLength-1){
			//initialzes the starting code sequences and message numbers
			keeper++; //tells and keeps track of how many lines done
			int messageNumber = sc.nextInt();
			int ASCIITotal = sc.nextInt();
			int lengthTotal = sc.nextInt();
			String newMessage = sc.nextLine(); 
			String message = newMessage.substring(1,newMessage.length()); //the substring is here to get rid of the space
			int errorCount = 0; //this will tell if confirmed can be used
			//STARTING PRINT
			System.out.print("transmission "+ messageNumber+ " ");
			
			//ERROR CHECKING-------------------------------------------------
			
			if(message.endsWith("over")){//Error if word does not end in over; if it does then nothing
				message = message.substring(0, message.length()-5);
			}else{
				System.out.print(" incomplete transmission");
				errorCount += 1; //error present
			}		
			if(message.length() == lengthTotal){
			}else{
				System.out.print(" length error,");
				errorCount += 1; //error present
			}
			if(ASCIIConvertor(message) == ASCIITotal){ //checks if the ASCII addition matches with what is given as the input using the method
			}else{
				System.out.print(" check total error,");
				errorCount += 1; //error present
			}
			if(errorCount == 0){//if no errors are present, then write confirmed
				System.out.print("Confirmed");
			}
			
			System.out.println();
			String encodedMessage = encoder(newMessage)+ " over"; //returns the encoded message and adds over as per the requirments
			System.out.println(encodedMessage); //second line of input
			System.out.println();
			
			
		}
		
		sc.close();
		
	}
	
	public static void secondMain() throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner("communications.txt"); //creates the scanner for 1 message
		sc.nextLine();//skips line
		//initialzes the starting code sequences and message numbers
		int messageNumber = sc.nextInt();
		int ASCIITotal = sc.nextInt();
		int lengthTotal = sc.nextInt();
		String newMessage = sc.nextLine(); 
		String message = newMessage.substring(1,newMessage.length()); //the substring is here to get rid of the space
		int errorCount = 0; //this will tell if confirmed can be used
		//STARTING PRINT
		System.out.print("transmission "+ messageNumber+ " ");
		
		//ERROR CHECKING-------------------------------------------------
		
		if(message.endsWith("over")){//Error if word does not end in over; if it does then nothing
			message = message.substring(0, message.length()-5);
		}else{
			System.out.print(" incomplete transmission");
			if(errorCount != 0){
				System.out.print(",");
			}
			errorCount += 1; //error present
		}		
		if(message.length() == lengthTotal){
		}else{
			System.out.print(" length error");
			if(errorCount != 0){
				System.out.print(",");
			}
			errorCount += 1; //error present
		}
		if(ASCIIConvertor(message) == ASCIITotal){ //checks if the ASCII addition matches with what is given as the input using the method
		}else{
			System.out.print(" check total error");
			if(errorCount != 0){
				System.out.print(",");
			}
			errorCount += 1; //error present
		}
		if(errorCount == 0){//if no errors are present, then write confirmed
			System.out.print("Confirmed");
		}
		
		System.out.println();
		String encodedMessage = encoder(newMessage)+ " over"; //returns the encoded message and adds over as per the requirments
		System.out.println(encodedMessage); //second line of input
		
		
		
		
	}
	public static String encoder(String input){ //this will encode the message as per the requirments
		
		for(int i = 0; i < input.length(); i++){//iterate through each character
			if(input.charAt(i) == 'f'){ //case with lower case f
				input = input.substring(0,i)+input.substring(i).replace(input.substring(i), "B")+input.substring(i+1,input.length());
				
			}else if(input.charAt(i) == 'F'){ //case with upper case f
				input = input.substring(0,i)+input.substring(i).replace(input.substring(i), "P")+input.substring(i+1,input.length());
			}else if(input.charAt(i) == 'e'){
				input = input.substring(0,i)+input.substring(i).replace(input.substring(i), "A")+input.substring(i+1,input.length());
			}else if(input.charAt(i) == ' '){
				input = input.substring(0,i)+input.substring(i).replace(input.substring(i), "e")+input.substring(i+1,input.length());
				
			}else if(input.charAt(i) == 't'){
				input = input.substring(0,i)+input.substring(i).replace(input.substring(i), ">?/")+input.substring(i+1,input.length());
				i += 3;
			}
			
		}
		return input;
	}
	
	public static int ASCIIConvertor(String input){
		int total = 0;//will keep track of the addition of the ASCII values
		for(int i = 0; i < input.length(); i++){ //adds up each character to determine total
			total += (int)input.charAt(i);
		}
		return total;
	}

}
