package ComputingClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LostCowProblem {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//LostCowLocation"));

		int johnLocation = sc.nextInt();
		int target = sc.nextInt();
		boolean side;
		if(johnLocation < target) side = true;
		else side = false;

		int currentDistance = 0;
		int recursive = 1;
		int currentLocation = johnLocation;
		boolean signSwitch = true;
		boolean stopper = false;

		while(!stopper){
			currentLocation = johnLocation;
			if(signSwitch){
				currentDistance += recursive;
				currentLocation += recursive;
			}else{
				currentDistance += recursive;
				currentLocation -= recursive;
			}
			if(currentLocation == target){
				stopper = true;
				break;
			}
			if(side){
				if(currentLocation > target){
					currentDistance -= (currentLocation - target);
					stopper = true;
					break;
				}
			}else{
				if(currentLocation < target){
					currentDistance += Math.abs((currentLocation - target));
					stopper = true;
					break;
				}				
			}
			currentDistance += recursive;
			signSwitch = !signSwitch;
			recursive *= 2;

		}

		System.out.println(currentDistance);
		sc.close();

	}

}
