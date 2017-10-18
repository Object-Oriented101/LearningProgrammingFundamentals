package bookPrograms;

public class CH4_IntegerLinkedListExecution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CH4_IntegerLinkedList sixth = new CH4_IntegerLinkedList(6);
		CH4_IntegerLinkedList fifth = new CH4_IntegerLinkedList(5,sixth);
		CH4_IntegerLinkedList fourth = new CH4_IntegerLinkedList(4,fifth);
		CH4_IntegerLinkedList third = new CH4_IntegerLinkedList(3,fourth);
		CH4_IntegerLinkedList second = new CH4_IntegerLinkedList(2,third);
		CH4_IntegerLinkedList first = new CH4_IntegerLinkedList(1,second);
		CH4_IntegerLinkedList head = new CH4_IntegerLinkedList(first);

		//Printing out all the data in a Linked List
		//Or simply the node
		for(CH4_IntegerLinkedList current = head; current != null; current = current.getNext()){
			//initialization = the start is with the starting point in the Linkedlist, the head
			//the last node will have a value that is null 
			System.out.print(current.getValue() +" ");
		}
		System.out.println();
		second.setNext(fourth);//this line deletes the third node by changing the reference to the one ahead
		
		for(CH4_IntegerLinkedList current = head; current != null; current = current.getNext()){
			System.out.print(current.getValue() +" ");
		}
	
	}

}
