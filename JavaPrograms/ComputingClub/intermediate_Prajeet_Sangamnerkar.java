
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class intermediate_Prajeet_Sangamnerkar {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner mainsc = new Scanner(System.in);
		secondMain(mainsc.nextLine());
		secondMain(mainsc.nextLine());
		secondMain(mainsc.nextLine());
		secondMain(mainsc.nextLine());
		secondMain(mainsc.nextLine());
		mainsc.close();

	}

	public static void secondMain(String input) throws FileNotFoundException{

		Scanner sc = new Scanner(input).useDelimiter(",| ");
		int total = sc.nextInt();
		sc.useDelimiter(", ");
		int[] playerDeck = new int[3];
		for(int i = 0; i < 3; i++){
			String s = sc.next();
			playerDeck[i] = convertor(s);
		}

		int playerMoveIndex = 0;
		int lostPlayer = -1;
		int playerCard = 0;

		while(sc.hasNext()){
			//Player Plays
			if(playerTurn(playerDeck, total)){
				playerMoveIndex = playerChooser(playerDeck, total); //returns the index of the highest allowed card
				if(playerDeck[playerMoveIndex] == 14){
					if(14 + total > 99){
						playerDeck[playerMoveIndex] = 1;
					}
				}
				playerCard = exceptionChanger(playerDeck[playerMoveIndex]); //gives playerCard the correct value to add or subtract, including the exceptions
				total += playerCard;
			}else{
				int x = 0;
				for(int i = 0; i < 3; i++){
					if(x < playerDeck[i]){
						x = playerDeck[i];
					}
				}
				total += x;
				lostPlayer = 0;
				break;
			}
			//Player Picks up new Card
			String nextCard = sc.next();
			int nextCardOfficial = convertor(nextCard);
			playerDeck[playerMoveIndex] = nextCardOfficial;
			//The Dealer
			int dealerPlay = convertor(sc.next());
			dealerPlay = dealerExceptionChanger(dealerPlay, total);
			if(dealerPlay + total > 99){
				total += dealerPlay;
				lostPlayer = 1;
				break;
			}else{
				total += dealerPlay;
			}
		}
		sc.close();

		if(lostPlayer == 0){
			System.out.println(total+", dealer" );
		}else if(lostPlayer == 1){
			System.out.println(total+", player");
		}
	}

	public static int exceptionChanger(int input){
		if(input == 9) return 0;
		if(input == 10) return -10;
		else return input;
	}
	public static int dealerExceptionChanger(int input, int currentTotal){
		if(input == 9) return 0;
		if(input == 10) return -10;
		if(input == 14){
			if(14 + currentTotal > 99){
				return 1;
			}else{
				return 14; 
			}
		}
		else return input;
	}
	public static boolean playerTurn(int[] array, int currentTotal){
		int value = 0;
		for(int i = 0; i < 3; i++){
			if(value < array[i]){
				value = array[i];
			}
		}
		if(value == 10) value = -10;
		if(value == 9) value = 0;
		if(value == 14){
			if(value + currentTotal > 99){
				value = 1;
			}
		}
		if(value + currentTotal <= 99){
			return true;
		}else{
			return false;
		}
	}
	public static int playerChooser(int[] array, int currentTotal){
		int index = 0;
		int value = 0;
		for(int i = 0; i < 3; i++){
			if(array[i] == 14){
				return i;
			}else{
				if(value < array[i]){
					index = i;
					value = array[i];
				}

			}
		}
		return index;
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
}
