package bookPrograms;

import java.util.Arrays;

public class CZ11_Heap {

	public int[] array = new int[10];
	public int size = 0;
	public int largestIndex = -1;
	public void add(int input) {
		size++;
		largestIndex++;
		array[largestIndex] = input;
		siftUp();
		
	}

	public void siftUp() {
		int parentIndex = (largestIndex-1)/2;
		int item = array[largestIndex];
		int targetIndex = largestIndex;
		while(targetIndex > 0) {
			if(array[parentIndex] <= item) {
				System.out.println(array[parentIndex] +"<="+ item);
				shift(array, targetIndex, parentIndex);
				targetIndex = parentIndex;
				parentIndex = (targetIndex-1)/2;
			}else {
				break;
			}
			
		}
	}
	public void siftDown(int index) {
		int child1 = 2*index + 1;
		int child2 = 2*index + 2;
		int targetIndex = index;
		boolean check = false;
		while(!check) {
			if(child1 > largestIndex) {
				System.out.println("Case false");
				check = true;
				break;
			}
			if(array[child1] > array[child2] && array[targetIndex] < array[child1]) {
				System.out.println("Child 1 > Child 2");
				System.out.println("Child 1:"+ array[child1] + " Child2: "+array[child2]);
				System.out.println();
				shift(array,targetIndex, child1); 
				targetIndex = child1;
			
			}else if(array[child2] > array[child1] && array[targetIndex] < array[child2]) {
				System.out.println("Child 1 < Child 2");
				System.out.println("Child 1:"+ array[child1] + " Child2: "+array[child2]);
				System.out.println("Switched " + array[child2] + " with " + array[targetIndex]);
				System.out.println();
				shift(array, targetIndex, child2);
				targetIndex = child2;
			}else {
				System.out.println("Break initiated");
				return;
			}
			
			child1 = 2*targetIndex + 1;
			child2 = 2*targetIndex + 2;
		}
	}
	public void delete(int index) {
		array[index] = array[largestIndex];
		array[largestIndex] = 0;
		System.out.println("Unsorted Array" + Arrays.toString(array));
		siftDown(index);
	}
	
	public void shift(int inArray[], int index1, int index2) {
		int temp = inArray[index1];
		inArray[index1] = inArray[index2];
		inArray[index2] = temp;
	}
}
