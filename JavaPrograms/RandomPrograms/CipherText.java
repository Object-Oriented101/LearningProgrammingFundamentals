package RandomPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CipherText {


	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		//Calculates total lines for array size
		Scanner previous = new Scanner(new File("//home//reality/Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//CipherTxt"));
		int lineCount = 0;
		while(previous.hasNextLine()){ //IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!
			previous.nextLine();//hasNextLine works based on the nextLine command. if nextLine not said, then it stays in place, which means it's true.
			previous.nextLine();//nextLine controls hasNextLine, so it needs to be stated here or else is a infinite loop
			lineCount++;
		}
		previous.close();

		//---------------------INPUT----------------------------------------
		Scanner sc = new Scanner(new File("//home//reality/Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//CipherTxt"));
		String[][] dataset = new String[lineCount][2];
		String[][] copy = new String[lineCount][2];

		int counter1 = 0;
		while(sc.hasNextLine()){
			String x = sc.nextLine();
			String y  = sc.nextLine();
			dataset[counter1][0] = x;
			dataset[counter1][1] = y;
			copy[counter1][0] = x;
			copy[counter1][1] = y;
			counter1++;
		}
		sc.close();


		//-----------------------MAIN ALGORITHM--------------------------------------
		int c = 0; //this is the counter that will keep track of the key of the cipher text, keeping it from going over
		for(int i = 0; i < dataset.length; i++){//this loop controls which word is being manipulated(in the [this one][0]
			String s = "";//this is where the new word is written
			c = 0;
			for(int y = 0; y < dataset[i][0].length(); y++){
				if(c == dataset[i][1].length()){//if the word length is reached, reset c to the first word
					c = 0;
				}
				//first, it converts the word to a specific letter and puts in the 0-26 scale; then it deducts from the char as the key in the 0-26 number scale; finally it adds 64 to convert back to ASCII
				char temp = (char)((((int)dataset[i][0].charAt(y)-64)-((int)dataset[i][1].charAt(c)-64))+64); 
				if(temp < 65){ //if the deduction for whatever reason was too much, then it will go back starting with Z
					temp = (char) ((int)temp + 26);
				}
				s = s + temp; //appends the decrypted letter into the String
				c++; //increments to move onto next letter of the key

			}
			dataset[i][0] = s; //adds the whole encrypted word into the correct place
		}

		//------------------------WRITES ONTO THE FILE AS PER REGULATION--------------------------------------
		PrintWriter writer = new PrintWriter(new File("//home/reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//PrintCipherText"));
		for(int i = 0; i < dataset.length; i++){
			writer.println(copy[i][0]+"/"+copy[i][1]+" = "+dataset[i][0]);
		}
		writer.close();


	}

}
