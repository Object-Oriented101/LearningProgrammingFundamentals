package bookPrograms;

public class CH2_Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		bunnies(1);
	}

	public static int bunnies(int n){
		if(n <= 2){
			return 1;
		}else{

		return bunnies(n-1)+bunnies(n-2);
		}
		
	}

}
