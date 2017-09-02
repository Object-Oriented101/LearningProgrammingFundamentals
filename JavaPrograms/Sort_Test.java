

public class Sort_Test {

	static void arrayPrinter(int array[], int arraylength){
		
		for(int i = 0; i < array.length; i++){
				
				System.out.println(array[i]);
				
			}
	}
	
	
	static void sort(int array[], int arraylength){
	
	boolean checker = false;
	int counter = 0;
	while(checker == false){
		
		for(int i = 0; i < arraylength-1; i++){
			
			if(array[i] > array[i+1]){
				
				int CONSTANT = array[i+1];
				array[i+1] = array[i];
				array[i] = CONSTANT;
			}else{
				counter++;
				if(counter == array.length+1){
					checker = true;
					//this decreases the time complexity by checking if the Dataset is already in order
				}
			}
			
		}
	}
}

	public static void main(String[] args) {
			
		int[] dataset = {2,4,5,1,3};
		arrayPrinter(dataset, dataset.length);
		sort(dataset, dataset.length);
		System.out.println("");
		arrayPrinter(dataset, dataset.length);
		
	}
	


}
