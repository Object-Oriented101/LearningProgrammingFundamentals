import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Vitamins {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("//home//reality//workspace//ComputingClub2//src//VitaminText"));

		int lineAmount = sc.nextInt();

		int[] singled = {100000000, 100000000,100000000};
		int[] doubled = {100000000,100000000,100000000,100000000,100000000,100000000};
		int tripled = 100000000;

		for(int i = 0; i < lineAmount; i++){
			int amount = sc.nextInt();

			String letter = sc.next();
			if(letter.length() == 1){
				
				 if(letter.equals("A") && singled[0] > amount){singled[0] = amount;}
				 else if(letter.equals("B") && singled[1] > amount){singled[1] = amount;}
				 else if(letter.equals("C")&& singled[2] > amount){;singled[2] = amount;}
				
			}else if(letter.length() == 2){
				
				if(letter.equals("BC") && doubled[0] > amount){doubled[0] = amount;}
				else if(letter.equals("CB") && doubled[1] > amount){doubled[1] = amount;}
				else if(letter.equals("AC") && doubled[2] > amount){doubled[2] = amount;}
				else if(letter.equals("CA") && doubled[3] > amount){doubled[3] = amount;}
				else if(letter.equals("AB") && doubled[4] > amount){doubled[4] = amount;}
				else if(letter.equals("BA") && doubled[5] > amount){doubled[5] = amount;}
				
			}else{if(tripled > amount){tripled = amount;}}
			
		}
		int combinedLettersAmount = singled[0] + singled[1] + singled[2];
		int endAmount = 100000000;
		//MATCHING EACH COMBINATIONS 1 -> 2
		int iterator = 0;
		for(int i = 0; i < 3; i++){
			for(int z = 0; z < 2; z++){
				if(doubled[iterator] == 100000000){
					iterator++;
					continue;
				}else{
					int possibleAmount = doubled[iterator] + singled[i];
					if(possibleAmount < endAmount){
						endAmount = possibleAmount;
					}
					iterator++;
				}
			}

		}
		//FOR BC and CB
	for(int i = 0; i < 2; i++){	

		for(int z = 2; z < 6; z++){
		
			if(doubled[z] == 100000000 || doubled[i] == 100000000){
				continue;
			}else{
				int temp = doubled[z] + doubled[i];
				if(temp < endAmount){
					endAmount = temp;
				}
			}
		}
	}
		//For AC and CA
	for(int i = 2; i < 4; i++){
		for(int z = 4; z < 6; z++){
			if(doubled[z] == 100000000 || doubled[i] == 100000000){
				continue;
			}else{
				int temp = doubled[z] + doubled[i];
				if(temp < endAmount){
					endAmount = temp;
				}
			}
		}
	}

	for(int i = 4; i < 6; i++){
		for(int z = 0; z < 4; z++){
			if(doubled[z] == 100000000 || doubled[i] == 100000000){
				continue;
			}else{
				int temp = doubled[z] + doubled[i];
				if(temp < endAmount){
					endAmount = temp;
				}
			}
		}
	}
		if(endAmount > combinedLettersAmount){
			endAmount = combinedLettersAmount;
		}if(endAmount > tripled){
			endAmount = tripled;
		}if(endAmount == 100000000){
			endAmount = -1;
		}
	
		

		System.out.println(endAmount);


	}

}
