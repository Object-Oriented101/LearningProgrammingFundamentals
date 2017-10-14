package bookPrograms;

public class CH2_StringRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		writeBackward("cat");

	}
	
	public static void writeBackward(String word){
		System.out.println("Word is equal to "+ word);
		if(word.length() == 0){ // The base case
			return; // saying that if nothing is left, then just return a value(allowed). 
		}
	
		System.out.print(word.substring(word.length()-1));
		System.out.println();
		writeBackward(word.substring(0,word.length()-1));
	}

}
