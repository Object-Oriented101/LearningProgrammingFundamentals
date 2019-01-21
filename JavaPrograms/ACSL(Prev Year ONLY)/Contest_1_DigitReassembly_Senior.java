import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Contest_1_DigitReassembly_Senior {
	/*
	 * Name: Prajeet Sangamnerkar
	 * School: Neuqua Valley HS
	 * Division: Junior
	 * Grade: 11
	 * Problem: Digit Reassembly
	 */
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//DigitReassemblySenior"));
		for(int i = 0; i < 5; i++){	
		solver(sc.next(), sc.nextInt());	}
		sc.close();
	}
	public static void solver(String text, int buffer){
		int counter = 0;
		boolean check = false;
		while(check == false){
			int currentNumber = Integer.parseInt(text.substring(0, buffer));
			counter += currentNumber;
			text = text.substring(buffer);

			if(text.length() < buffer){
				int difference = buffer - text.length();
				for(int i = 0; i < difference; i++){
					text += "0";
				}
				
				int realNumber = Integer.parseInt(text);
				counter+= realNumber;
				System.out.println(counter);
				check = true;
			}
		}
	}


}
