package bookPrograms;

public class CH2_Towers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		towers(5,'A','B','C');

	}
	
	public static void towers(int count, char source, char destination, char spare){
		
		if(count == 1){// the base case; move from one to another because only one disk present
			System.out.println("Move disk " + source + " to "+ destination);
		}else{
			towers(count-1, source,spare,destination); // moves every disk but the bottom most one to the spare from the source
			towers(1,source,destination,spare); // moves the one missing disk from the source to the destination
			towers(count-1, spare, destination, source); //moves the disk that were moved to the spare into the destination
			//this is chunking a big problem into simple,repeatable steps
		}
		
	}

}
