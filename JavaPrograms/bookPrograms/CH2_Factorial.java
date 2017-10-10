package bookPrograms;

public class CH2_Factorial {


	public static void main(String[] args) {
		
		System.out.println(factorialCalculator(5));
		
	}
	
	public static int factorialCalculator(int n){
			if(n == 0){
				return 1; //fact(0) is simply one. This is the base case because for negative numbers it's undefined
				//This case will define the rest of the problem and factorials
			}
			
			else{
				return n * factorialCalculator(n-1);//the recursive case
				// this is the heart of the problem
				/*-----------------------------------------------
				 * n will start with 5. It will multiply it by fact(4). But fact 4 is 4 * fact(3). Same with 3, which is 3*fact(2).
				 * This goes on until it reaches 1. In which you know what fact(0) is. Since you know what that is, you know
				 * what is fact(1), which is 1 *1. Then you know what fact(2) is, 2 *1*1. Then you know what fact(3) is, 3*2*1*1.
				 * The hardest part is understanding that it's much of a cycle, where it's going one way to reach the base case,
				 * then goes the other way to define the factorial for each number until it gets back to n. 
				 */
				}
		
	}

}
