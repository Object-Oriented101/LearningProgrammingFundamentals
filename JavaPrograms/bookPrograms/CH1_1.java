package bookPrograms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

	
public class CH1_1 {

	
	public static void main(String[] args) {
		//This creates scanner for the input
		Scanner reader = new Scanner(System.in);
		
		System.out.println("The total amount needed to pay is:");
		double PAY_AMOUNT = reader.nextInt(); //Desired amount to pay off
		
		if(PAY_AMOUNT != (int)PAY_AMOUNT){
			System.out.println("Please only enter a number");
		}
		System.out.println("The amount of dollars given is:");
		double DOLLARS = reader.nextInt();
		
		System.out.println("The amount of cents given is:");
		double CENTS = reader.nextInt();
		
		//No checker to see if nextInt is not int == need to develop error checking
		changeCalculator(PAY_AMOUNT, DOLLARS, CENTS);
		
		reader.close();

	}
	public static double round(double value, int places) { //ONLINE PROGRAM FOR ROUNDING 2 PLACES
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}	
	
	public static void changeCalculator(double PAY_AMOUNT, double DOLLARS, double CENTS){
		// The due payment and amount of money is taken in as arguments.
		//This method will compute to see how much and if any change is needed.
		CENTS = CENTS / 100;
		double GIVEN_AMOUNT = DOLLARS + CENTS;
		
		if(PAY_AMOUNT > GIVEN_AMOUNT){
			System.out.println("You have not given enough money to meet the payment.");
		}else if(PAY_AMOUNT == GIVEN_AMOUNT){
			System.out.println("You don't require any change.");
		}else{ 
			// This method calculates the given change
			double CHANGE = GIVEN_AMOUNT - PAY_AMOUNT;
			System.out.println("You require $"+ round(CHANGE, 2) + " of change.");
			
		} //OUTPUTS what will happen
		

		
	}

}
