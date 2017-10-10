package bookPrograms;

public class CH2_numBackward {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		numBack(5);

	}
	
	public static void numBack(int target){
		
		if(target == 0){ //this is the base case. Stops at 0
			return; 
		}
		System.out.println(target);
		numBack(target-1);
		
	}

}
