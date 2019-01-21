import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Contest_2_Diff {

	public static void main(String[] args) throws FileNotFoundException {


		Scanner sc = new Scanner(new File("//home//reality//Documents//LearningProgrammingFundamentals//JavaPrograms//TextFiles//diff.txt"));
		for(int r = 0; r< 5; r++) {
			String A = sc.next();
			String B = sc.next();



			//		System.out.println(A);
			//		System.out.println(B);
			String[] commonHolder = new String[4];
			commonHolder[0] = commonFinder(A,B);
			commonHolder[1] = commonFinder(B,A);
			commonHolder[2] = commonFinderBack(A,B);
			commonHolder[3] = commonFinderBack(A,B);
			String common1 = globalCommonFinder(commonHolder[0], commonHolder[3]);		
			String common2 = globalCommonFinder(commonHolder[1], commonHolder[2]);	
			String common3 = globalCommonFinder(common1, common2);
			//		System.out.println(common3);
			removeSame(common3);
			System.out.println();

			//		for(int i = 0; i < commonHolder.length; i++) {
			//			System.out.println(commonHolder[i]);
			//		}
		}

	}

	public static void removeSame(String word) {
		String common = "";
		if(word.length() == 0) {
			System.out.print("NONE");
			return;
		}
		while(word.length() != 0 ) {
			common += word.substring(0,1);

			word = word.replaceAll(word.substring(0,1), "");
			//			System.out.println(dd"CHANGE: "+ word);

			if(word.length() == 0) {
				break;
			}
		}
		ArrayList<String> test = new ArrayList<String>();

		for(int i = 0; i < common.length(); i++) {
			test.add(common.substring(i,i+1));
		}

		Collections.sort(test);
		for(int i = 0; i < test.size(); i++) {
					System.out.print(test.get(i));
		}
	}

	public static String globalCommonFinder(String wordA, String wordB) {
		String common = "";
		for(int i = 0; i < wordA.length(); i++) {

			for(int z = 0; z < wordB.length(); z++) {
				if(wordA.substring(i,i+1).equals(wordB.substring(z,z+1))) {
					common += wordA.substring(i,i+1);
				}

			}

		}
		return common;
	}

	public static String commonFinder(String wordA, String wordB) {
		String common = "";

		for(int i = 0; i < wordA.length(); i++) {
			String letter = wordA.substring(i,i+1);

			for(int z = 0; z < wordB.length(); z++) {
				//			System.out.println("Comparing " + letter + " " + wordB.substring(z,z+1));
				if(letter.equals(wordB.substring(z,z+1))){
					common += letter;
					wordB = wordB.substring(z+1);
					z = 0;
					//				System.out.println(wordB);
				}
			}
		}

		//		System.out.println(common);
		return common;
	}

	public static String commonFinderBack(String wordA, String wordB) {
		String common = "";

		for(int i = wordA.length()-1; i > -1 ; i--) {

			String letter = wordA.substring(i,i+1);

			for(int z = wordB.length()-1; z > -1; z--) {
				//				System.out.println("Comparing " + letter + " " + wordB.substring(z,z+1));

				if(wordB.length() == 0) {
					break;
				}

				//				System.out.println("HERE");
				if(letter.equals(wordB.substring(z,z+1))){
					common += letter;
					wordB = wordB.substring(0,z);
					z = wordB.length()-1;
					//					System.out.println("WORD IS: " + wordB);
				}
			}
		}

		//		System.out.println(common);
		return common;
	}

}
