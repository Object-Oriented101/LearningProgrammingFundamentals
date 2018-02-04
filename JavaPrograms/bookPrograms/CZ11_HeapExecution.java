package bookPrograms;

import java.util.Arrays;

public class CZ11_HeapExecution {
	
	public static void main(String args[]) {
	CZ11_Heap heap = new CZ11_Heap();
	heap.add(5);
	heap.add(4);
	heap.add(3);
	heap.add(1);
	heap.add(2);
	heap.add(8);
	heap.add(3);
	System.out.println(Arrays.toString(heap.array));
	heap.delete(1);
	System.out.println(Arrays.toString(heap.array));
	}
	
	
	
}
