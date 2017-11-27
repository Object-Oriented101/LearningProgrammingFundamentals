package ComputingClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FencePainting {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//ALL TEST CASES WORK
		Scanner sc = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//FencePaintingData"));
		int johnStart = sc.nextInt();
		int johnEnd = sc.nextInt();
		int bessieStart = sc.nextInt();
		int bessieEnd = sc.nextInt();
		sc.close();
		if(johnStart > bessieEnd){
			System.out.println((johnEnd - johnStart)+(bessieEnd-bessieStart));
		}else if(johnStart > bessieStart && johnEnd < bessieEnd){
			System.out.println(bessieEnd - bessieStart);
		}else if(bessieStart > johnStart &&  johnEnd > bessieEnd){
			System.out.println(johnEnd - johnStart);
		}else if(johnEnd < bessieStart){
			System.out.println((johnEnd - johnStart)+(bessieEnd-bessieStart));
		}else if(johnStart < bessieStart && bessieStart <= johnEnd){
			System.out.println(bessieEnd-johnStart);
		}else if(johnStart > bessieStart && johnStart <= bessieEnd){
			System.out.println(johnEnd-bessieStart);
		}else if(johnEnd == bessieEnd && johnStart == bessieStart){
			System.out.println(johnEnd - johnStart);
		}
		
		
	}

}
