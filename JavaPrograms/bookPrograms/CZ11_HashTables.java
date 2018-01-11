package bookPrograms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CZ11_HashTables {


	public static void main(String args[]) {


		add(1);
		add(1);
		add(1);
		add(1);
		add(1);
		add(1);
		add(1);
		add(1);
		add(1);
		remove(1);
		add(1);
		System.out.println(Arrays.toString(array));
		find(2);
	}
	public static int[] array = new int[10];


	private static int Hash(int input) {
		int generator = input % array.length;
		return generator;
	}

	public static void add(int input) {
		int index = Hash(input);
		if(array[index] == 0) {
			array[Hash(input)] = input;
		}else {
			array[indexReturner(index, 0)] = input;
		}
	}

	public static void remove(int input) {
		int index = Hash(input);

		if(array[index] == input) {

			array[index] = 0;
		}else {
			System.out.println("This element is not present in the array");
		}
	}
	public static void find(int input) {
		int index = Hash(input);
		if(array[index] == input) {
			System.out.println(index);
			System.out.println("Number is present");
		}else {
			System.out.println("Not present");
		}
	}

	private static int indexReturner(int inputIndex, int counter) {

		if(counter == array.length-2) {
			return indexReturner(-1, 0);
		}
		
		if(array[inputIndex + 1] == 0) {
			return inputIndex + 1;
		}
		counter++;
		return indexReturner(inputIndex+1,counter);
	}


}




