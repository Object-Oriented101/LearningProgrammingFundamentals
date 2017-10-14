package ComputingClub;

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CowTime
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(new File("//home//reality//Documents//TextFiles//CowTimeFile"));

		int max = sc.nextInt();
		System.out.println(max);
		int[][] holder = new int[max][2]; //creates the array that will hold all the times together
		int TIME = 0;// This variable holds the current time

		for(int i = 0; i < holder.length; i++){ // takes in the input from the file
			holder[i][0] = sc.nextInt();
			holder[i][1] = sc.nextInt();
		}
		
		sorter(holder);
		printer(holder);
		
		for(int i = 0; i < max; i++){
			if(i + 1 == max){
				break;
			}
			if(holder[i][0]+holder[i][1] < holder[i+1][0]){
				TIME = holder[i+1][0];
			}else{
				TIME = holder[i][0]+holder[i][1]+holder[i+1][1];
			}
		}
		System.out.println(TIME);
		
		sc.close();

	}

	public static void sorter(int array[][]){ //this will sort the two dimensional array

		for(int i = 0;i < array.length; i++){// if next index is smaller than current one, swap the values

			if(i+1 == array.length){
				break;
			}
			if(array[i][0] > array[i+1][0]){
			
				int temp = array[i][0];
				int temp2 = array[i][1];

				array[i][0] = array[i+1][0];
				array[i][1] = array[i+1][1];
				array[i+1][0] = temp;
				array[i+1][1] = temp2;

			}


		}
	}
	
	public static void printer(int array[][]){
		
		for(int i = 0;i < array.length; i++){
			System.out.println(array[i][0]+","+array[i][1]);
		}
	}
}


