package bookPrograms;

public class CH4_ADTBasic {

	private int[] dataset;
	private int size;
	private int datasetCounter = 0;

	//The Constructor-----------------------------------------------------
	public CH4_ADTBasic(int in_size){ //the constructor which requires the size of the array
		size = in_size;
		dataset = new int[size];
	}
	//The Basic Methods of an ADT------------------------------------------
	public void printDataset(){ //prints all the values in the dataset
		for(int i = 0; i < dataset.length; i++){
			System.out.print(dataset[i]+" , ");
		}
	}
	public void addDataset(int number){ // adds a number
		if(datasetCounter == dataset.length){
			incArraySize();	
		}
		dataset[datasetCounter] = number; 
		datasetCounter++;
	}
	public void removeDataset(int position){ //removes an existing number
		if(position > size){
			try {
				throw new Exception("Position "+position+" doesn't exist. Please try a different one.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		dataset[position-1] = 0;
	}
	public void replaceDataset(int number, int position){
		dataset[position-1] = number;
	}
	//If the array size is exceeded, then size is double--------------------------------------------
	private void incArraySize(){
		int[] newArray = new int[size+1];
		//size = size+1;
		for(int i = 0; i < dataset.length; i++){
			newArray[i] = dataset[i];
		}
		dataset = newArray;
		System.out.println("Length of Dataset after increasing is "+ dataset.length);
	}

}
