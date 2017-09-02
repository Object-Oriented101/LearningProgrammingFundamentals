
public class AppendingArray {
	
	public static int[] dataset = {1,2,3,4,6};
	public static int[] InsertedDataset = new int[dataset.length+1];
	

	static void insertorArray(int array[], int arrayLength, int insertionNumber, int insertionIndex){
		
		//some comments were used for testing program
		int[] newArray;
		newArray = new int[arrayLength + 1];
		
		for(int i = 0; i < insertionIndex - 1 ; i++){
			newArray[i] = array[i]; //puts in data before the indexed value
		}
	
		newArray[insertionIndex-1] = insertionNumber; //puts the index value in place
		//System.out.println("\nSecond Set");
		//arrayPrinter(newArray, newArray.length);
		
		for(int i = insertionIndex; i < arrayLength+1; i++){
			newArray[i] = array[i-1]; //puts the values after the indexed values
		}
		//System.out.println("Third Set");
		//arrayPrinter(newArray, newArray.length);
		

		for(int i = 0; i < newArray.length; i++){ //puts data into new array to print in console
				 InsertedDataset[i] = newArray[i]; 
				}
	}
	
	public static void main(String[] args) {
 
		arrayPrinter(dataset, dataset.length);//Before
		insertorArray(dataset, dataset.length, 5, 3); //-----------Here's where the insertion is chosen
		System.out.println("\nAfter Data is sorted:");
		arrayPrinter(InsertedDataset, InsertedDataset.length); //After
	}
	
	

	
	static void arrayPrinter(int array[], int arraylength){//creates method that will print an array
		
		for(int i = 0; i < array.length; i++){
				System.out.print(array[i]);
				}
	}
	
}
