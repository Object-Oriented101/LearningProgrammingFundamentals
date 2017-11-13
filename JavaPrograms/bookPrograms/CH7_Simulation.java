package bookPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CH7_Simulation {


	public static void main(String[] args) throws FileNotFoundException {

		CH7_QueueListBased lineTime = new CH7_QueueListBased();
		CH7_QueueListBased lineSpent = new CH7_QueueListBased();
		Scanner s = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//CH7_SimulationText"));

		int[] arrivalTime = new int[50];
		int[] timeSpent = new int[50];
		int counter = 0;
		

		for(int i = 0; i < 4; i++){
			arrivalTime[counter] = s.nextInt();
			timeSpent[counter] = s.nextInt();
			counter++;
		}
		
		System.out.println(arrivalTime[1]);

		for(int i = 0; i < 4; i++){
			lineTime.enqueue(arrivalTime[i]);
		}
		for(int i = 0; i < 4; i++){
			lineSpent.enqueue(timeSpent[i]);
		}

		int[] averageWaiting = new int[5];
		int waitingCounter = 0;
		
		
		
		
		s.close();
	}

}
