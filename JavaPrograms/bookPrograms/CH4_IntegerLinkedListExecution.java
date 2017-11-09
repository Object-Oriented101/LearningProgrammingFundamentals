package bookPrograms;

public class CH4_IntegerLinkedListExecution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CH4_Node sixth = new CH4_Node(6); 
		CH4_Node fifth = new CH4_Node(5,sixth);
		CH4_Node fourth = new CH4_Node(4,fifth);
		CH4_Node third = new CH4_Node(3,fourth);
		CH4_Node second = new CH4_Node(2,third);
		CH4_Node first = new CH4_Node(1,second);
		CH4_Node head = new CH4_Node(first);

		//Printing out all the data in a Linked List
		System.out.println("Starting Set: ");
		for(CH4_Node current = head; current != null; current = current.getNext()){
			//initialization = the start is with the starting point in the Linkedlist, the head
			//the last node will have a value that is null 
			System.out.print(current.getValue() +" ");
		}

		System.out.println();
		second.setNext(fourth);//this line deletes the third node by changing the reference to the one ahead
		System.out.println("Deleting a Node: ");
		for(CH4_Node current = head; current != null; current = current.getNext()){
			System.out.print(current.getValue() +" ");
		}
	}
}
