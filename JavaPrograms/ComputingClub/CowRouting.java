package ComputingClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CowRouting {
	// ALL TEST CASES GIVE CORRECT OUTPUT
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//CowRoutingFlightPattern"));

		int startingCity = sc.nextInt();
		int landingCity = sc.nextInt();
		int totalFlights = sc.nextInt();

		int cost = 1001;
		int flightDoneCounter = 0;

		while(flightDoneCounter != totalFlights){

			int tempCost = sc.nextInt();
			int flightAmount = sc.nextInt();
			int[] currentFlightCities = new int[flightAmount];

			int flightStationCounter = 0;
			int arrayCounter = 0;

			while(flightStationCounter != flightAmount){
				currentFlightCities[arrayCounter] = sc.nextInt();
				arrayCounter++;
				flightStationCounter++;
			}
			int foundA = 0;
			int foundB = 0;
			for(int i = 0; i < flightAmount; i++){
				if(foundA == 0){	
					if(currentFlightCities[i] == startingCity){
						foundA = 1;
					}
				}else if(foundA == 1){
					if(currentFlightCities[i] == landingCity){
						foundB = 1;
						if(cost > tempCost){
							cost = tempCost; 
						}
						break;
					}
				}
			}
			if((foundA == 1 && foundB == 1) && cost > tempCost){
				cost = tempCost; 
			}
			++flightDoneCounter;
		}
		sc.close();
		if(cost == 1001){
			System.out.println("-1");
		}else{
			System.out.println(cost);
		}

	}

}
