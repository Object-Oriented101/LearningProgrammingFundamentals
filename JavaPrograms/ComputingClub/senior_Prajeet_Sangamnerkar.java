

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class senior_Prajeet_Sangamnerkar {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner mainsc = new Scanner(System.in).useDelimiter("");
		mainsc.useDelimiter(", ");
		int[] player1 = new int[5];
		int[] player2 = new int[5];
		for(int i = 0; i < 5; i++){
			player1[i] = convertor(mainsc.next());
		}
		sorter(player1);
		int[] holder1 = new int[5];
		for(int i = 0; i < 5; i++){
			holder1[i] = player1[i];
		}
		for(int i = 0; i < 4; i++){
			player2[i] = convertor(mainsc.next());
		}
		player2[4] = convertor(mainsc.nextLine().substring(2,3));
		sorter(player2);
		int[] holder2 = new int[5];
		for(int i = 0; i < 5; i++){
			holder2[i] = player2[i];
		}
		secondMain(mainsc.nextLine(), player1, player2);
		for(int i = 0; i < 5; i++){
			player1[i] = holder1[i];
		}
		for(int i = 0; i < 5; i++){
			player2[i] = holder2[i];
		}
		secondMain(mainsc.nextLine(), player1, player2);
		for(int i = 0; i < 5; i++){
			player1[i] = holder1[i];
		}
		for(int i = 0; i < 5; i++){
			player2[i] = holder2[i];
		}
		secondMain(mainsc.nextLine(), player1, player2);
		for(int i = 0; i < 5; i++){
			player1[i] = holder1[i];
		}
		for(int i = 0; i < 5; i++){
			player2[i] = holder2[i];
		}
		secondMain(mainsc.nextLine(), player1, player2);
		for(int i = 0; i < 5; i++){
			player1[i] = holder1[i];
		}
		for(int i = 0; i < 5; i++){
			player2[i] = holder2[i];
		}
		secondMain(mainsc.nextLine(), player1, player2);

		mainsc.close();

	}
	public static void deckReady(int[] p1, int[] p2){
		
	}

	public static void secondMain(String input, int[] p1, int[] p2) throws FileNotFoundException{

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(input).useDelimiter(",| ");

		int total = sc.nextInt();
		sc.useDelimiter(", ");

		int iteration = 1;
		while(iteration < 12){ // this line is a bit sketchy but for now will do
//			System.out.println("Iteration" + iteration);
			iteration++;
//			System.out.println("STARTING TOTAL---------- = " + total);
			//Player 1 Plays
			int chosen = p1[2];
			chosen = realConvertor(chosen, total); //considers the exceptions
//			System.out.println("Chosen is:"+ chosen);
//			System.out.println("Player 1's Array");
//			arrayPrintor(p1);
			if(isPossible(chosen, total)){
				int newTotal = total + chosen;
//				System.out.println("Player 1 Number Chosen " + chosen);
				newTotal = total + borderDeterminer(total,newTotal) + chosen;
				total = newTotal;
//				System.out.println("Total after Player1 plays " + total);

				if(total > 99){
					int newtotal = total + chosen;
					total = total + borderDeterminer(total, newtotal)+ chosen;
					System.out.println(total+", Player #2");
					break;
				}

			}else{
//				System.out.println(total);
				//Player 1 Lost
				int newtotal = total + chosen;
				total = total + borderDeterminer(total, newtotal)+ chosen;
				System.out.println(total+", Player #2");
				break;
			}
			//Player 1 picks up a new card
			int newCard = convertor(sc.next());
			p1[2] = newCard; //replaces the middle card always
//			System.out.println("Player 1 new card: " + newCard);
			sorter(p1); //keeps the deck sorted without considering the exception values


			//Player 2 Plays
			sorter(p2);
			int chosen1 = p2[2];
			chosen1 = realConvertor(chosen1, total);
//			System.out.println("Player 2's Array");
//			arrayPrintor(p2);
			if(isPossible(chosen1, total)){
				int newTotal1 = total + chosen1;
//				System.out.println("          Player 2 chosen card "+ chosen1);
				newTotal1 = total + borderDeterminer(total, newTotal1) + chosen1;
				total = newTotal1;
//				System.out.println("          Player 2 new total "+ newTotal1);
				if(total > 99){
					int newtotal = total + chosen1;
					total = total + borderDeterminer(total, newtotal)+ chosen1;
					System.out.println(total+", Player #1");
					break;
				}
			}else{
				//Player 2 has lost
				int newtotal = total + chosen1;
				total = total + borderDeterminer(total, newtotal)+ chosen1;
				System.out.println(total+", Player #1");
				break;
			}

			int newCard1 = convertor(sc.next());
			p2[2] = newCard1;
//			System.out.println("          Player 2 picked card "+ newCard1);
			sorter(p2);

		}

	}
	public static boolean isPossible(int value, int currentTotal){
		int laterTotal = value+currentTotal;
		if(value + currentTotal <= 99){
			if(borderDeterminer(currentTotal, laterTotal) + value + currentTotal <= 99){
				return true;
			}
		}
		return false;

	}
	public static int borderDeterminer(int previousTotal, int afterTotal){
//		System.out.println("                                  "+previousTotal+ "    "+ afterTotal);
		int x = 0;

		if(afterTotal == 33 || afterTotal == 34){
			x = 0;
		}else if(afterTotal == 55 || afterTotal == 56){
			x = 0;
		}else if(afterTotal == 77 || afterTotal == 78){
			x = 0;
		}else if((previousTotal == 33 || previousTotal == 34) && afterTotal > 34){
			x += 5;
		}else if((previousTotal == 33 || previousTotal == 34) && afterTotal < 33){
			x += 5;
		}else if((previousTotal == 55 || previousTotal == 56) && afterTotal > 56){
			x += 5;
		}else if((previousTotal == 55 || previousTotal == 56) && afterTotal < 55){
			x += 5;
		}else if((previousTotal == 77 || previousTotal == 78) && afterTotal > 78){
			x += 5;
		}else if((previousTotal == 77 || previousTotal == 78) && afterTotal < 77){
			x += 5;
		}else if(previousTotal < 77 && afterTotal > 78){
			x+=5;
		}else if(previousTotal > 78 && afterTotal < 77){
			x+=5;
		}else if(previousTotal < 33 && afterTotal > 34){
			x+=5;
		}else if(previousTotal > 34 && afterTotal < 33){
			x+=5;
		}else if(previousTotal < 55 && afterTotal > 56){
			x+=5;
		}else if(previousTotal > 56 && afterTotal < 55){
			x+=5;
		}
		/*



		if(previousTotal == 33 || previousTotal == 34 || afterTotal == 33 || afterTotal == 34){
			x += 5;
		}else if(previousTotal == 55 || previousTotal == 56 || afterTotal == 55 || afterTotal == 56){
			x += 5;
		}else if(previousTotal == 77 || previousTotal == 78 || afterTotal == 77 || afterTotal == 78){
			x += 5;
		}
		 */



		return x;
	}
	public static int realConvertor(int input, int currentTotal){

		if(input == 9) return 0;
		if(input == 10) return -10;
		if(input == 7){
			if(7 + currentTotal <= 99){
				return 7;
			}else{
				return 1;
			}

		}
		else return input;
	}
	public static int convertor(String input){ //Converts the letters into numbers
		if(Character.isLetter(input.charAt(0))){
			int x = 0;
			if(input.charAt(0) == 'T'){
				x = 10;
			}else if(input.charAt(0) == 'J'){
				x = 11;
			}else if(input.charAt(0) == 'Q'){
				x = 12;
			}else if(input.charAt(0) == 'K'){
				x = 13;
			}else if(input.charAt(0) == 'A'){
				x = 14;
			}
			return x;

		}else{
			return Integer.parseInt(input);
		}
	}
	public static void arrayPrintor(int[] input){
		for(int i = 0; i < input.length; i++){
			System.out.println(input[i]);
		}
	}
	public static void sorter(int[] array){
		for(int i = 0; i < 4; i++){
			for(int z = 0; z < 4; z++){
				if(array[z] > array[z+1]){
					int temp = array[z+1];
					array[z+1] = array[z];
					array[z] = temp;
				}
			}
		}
		//		System.out.println("The sorter method returns the following");
		//		arrayPrintor(array);
		//		System.out.println("--------------");
	}
}
