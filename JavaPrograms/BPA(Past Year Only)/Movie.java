import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class Movie {

	/**
	Contest Number: 23-0053-0048
	Name: Prajeet Sangamnerkar
	ID: 2003533
	NV
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//initializes the scanner class to use it to take in input
		DecimalFormat formatGenerator  = new DecimalFormat("#0.00");  //this will be used later to format the average ratins; 0.00 indicates 2 place values after decimal
		//		int movieNumberCount = 1; //keep track of which movie is being rated so that the output movie number will match

		System.out.println("How many movies are you rating?");//Initializes the amount of movies rated; will be used in the future
		int movieTotalNumber = 0; //dummy number
		try{http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=881
		movieTotalNumber http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=881= sc.nextInt();
		}catch(Exception inputMistException){
			System.out.println("Incorrect Data has been Entered");
			System.exit(0);
		}
		System.out.println();
		for(int movieCounter = 1; movieCouhttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=881nter <= movieTotalNumber; movieCounter++){

			//Taking in values from the user
			
			//takes movie review as int
			System.out.println("Please enter ratings from the movie review website for movie #" + movieCounter); //takes movie review as int
			int movieRating1 = 0;//initializes values to dummy ones. Will be given new value.
			int movieRating2 = 0;
			int movieRating3 = 0;
			try{
				movieRating1 = sc.nextInt();
				movieRating2 = sc.nextInt();
				movieRating3 = sc.nextInt();
				System.out.println();
			}catch(Exception InputMismatchException){ //if the user entered anything other than a double, this message will be thrown.
				System.out.println("Incorrect data has been entered");
				break;
			}
			
			
			//takes in focus group rating as doubles
			double focusRating1 = 0;//initializes values to dummy ones. Will be given new value.
			double focusRating2 = 0;
			try{
				System.out.println("Please enter ratings from the focus group for movie #"+ movieCounter); 
				focusRating1 = sc.nextDouble();
				focusRating2 = sc.nextDouble();
				System.out.println();
			}catch(Exception InputMismatchException){
				System.out.println("Incorrect data has been entered");
				break;
			}

			double movieCriticRating = Math.random()*101; //generates a number(or percent) from 0 to 100 as per the percent scale
			System.out.println("Ratings for movie #" + movieCounter);

			//Calculating the values based on the given input

			//Average Website Rating Computation 
			double averageWebsiteRating = (double)(movieRating1 + movieRating2 + movieRating3) /3; // computes the average of 3 
			System.out.println("Average website rating: " + formatGenerator.format(averageWebsiteRating));//Prints the calculation in previous line with the formatGenerator to get it to two place values

			//Average Focus Group Rating Computation
			double averageFocusRating = (focusRating1 + focusRating2)/2; //computes average of 2 of the focus ratings given
			System.out.println("Average focus group rating: " + formatGenerator.format(averageFocusRating));//Prints calculation in previous line along with format Generator to make sure goes to two places

			System.out.println("Average movie critic rating: " + formatGenerator.format(movieCriticRating));//prints randomly generate movie critic rating from before

			//Calculating weighted average
			double weightedAverageRating = averageWebsiteRating * 0.2 + averageFocusRating * 0.3 + movieCriticRating*0.5; //each average rating is multiplied by its weighted percent to calculate the total weighted average as per the prompt
			System.out.println("Overall movie rating: " + formatGenerator.format(weightedAverageRating)); //prints the weighted average

			System.out.println();

		}


		sc.close();

	}
}
