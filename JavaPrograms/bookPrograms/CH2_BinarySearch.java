package bookPrograms;

public class CH2_BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int dataset[] = {1,2,3,4,5,6};// the dataset(assumed to be sorted

		binarySearch(dataset,0, dataset.length,0);

	}

	public static void binarySearch(int[] dataset,int first, int last, int target){

		System.out.println("Initially binarySearch(dataset ,"+ first +" , "+ last +" , "+target+");");
		//last--;
		int middle = (first + last)/2;

		//This is the recursive solution
		if(dataset[middle] == target){ //If the dataset is in the middle, returns true
			System.out.println("Number is found: index " + middle);
			System.out.println("True");
		}else if(target < dataset[middle]){
			System.out.println("The number is less than the middle index "+ middle);
			System.out.println("binarySearch(dataset ,"+ first +" , "+ middle +" , "+target+");");
			binarySearch(dataset,first,middle, target);
		}else if(target > dataset[middle]){
			System.out.println("The number is greator than the middle number"+ dataset[middle]);
			System.out.println("binarySearch(dataset,"+ middle +", "+last+", "+target+");");
			binarySearch(dataset,middle, last, target);
		}			
		if(middle == 0){
			System.out.println("Your number is not present in the dataset");
		}



		/*
		 * else if(target > dataset[middle]){
			System.out.println("The number is greator than the middle number"+ dataset[middle]);
			System.out.println("binarySearch(dataset,"+ middle +", "+last+", "+target+");");
			binarySearch(dataset,middle, last, target);
		}

				if(dataset.length == 1){ //this is if only one number in the dataset
			if(dataset[0] == target){ 
				System.out.println("True");// this has been confirmed to work 
			}else{
				System.out.println("False");
			}
		}
		 */


	}
}
