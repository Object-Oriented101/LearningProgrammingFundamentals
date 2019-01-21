import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;


public class Contest_1_DigitReassembly {
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
		Scanner sc = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//DigitReassmeblyText"));
		for(int i = 0; i < 5; i++){
			solver(sc.next(), sc.nextInt());	
		}
		sc.close();
		
		

	}
	public static void solver(String text, int buffer){
		BigInteger counter = new BigInteger("0");

			for(int i = 0; i < text.length()-buffer+1; i++){
				BigInteger currentBuffer = new BigInteger(text.substring(i,i+buffer));
				counter = counter.add(currentBuffer);
			}
			System.out.println(counter);
	}

}
