package ComputingClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CowCross {

	
	public static void main(String[] args) throws FileNotFoundException  {
		
		Scanner x = new Scanner(new File("//home//reality//Documents//TextFiles//CowData"));
		
		int OBS = x.nextInt();
		System.out.println(OBS);
		
		int[] cowNames = new int[20];
		int[] cowID= new int[20];
				

			
	
				cowNames[0] = x.nextInt();
				System.out.println(cowNames[0]);
			
			/*
		for(int i = 0; i < cowNames.length; i++){
			System.out.print(cowNames[i]+ "\t");
			System.out.println(cowID[i]);
		}
		*/
		x.close();
		
		
		
	}
	

}
