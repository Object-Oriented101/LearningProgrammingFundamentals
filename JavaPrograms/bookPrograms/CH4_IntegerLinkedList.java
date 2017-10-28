package bookPrograms;

public class CH4_IntegerLinkedList {


	private int storedValue; //the node will store this value
	private CH4_IntegerLinkedList next; //the references to the next node
	
	
	//----------------------THE CONSTRUCTORS-----------------------------
	public CH4_IntegerLinkedList(int input){ //if only the value is given, invoke this constructor
		storedValue = input;
		next = null;
	}
	public CH4_IntegerLinkedList(int input, CH4_IntegerLinkedList in_object){ //if both are given, put the values in respectively
		storedValue = input; //the value this node will hold
		next = in_object;// reference to the next node
	}
	public CH4_IntegerLinkedList(CH4_IntegerLinkedList in_object){ //if only the value is given, invoke this constructor
		next = in_object;
	}
	
	//-------------------------THE GETTERS AND SETTERS--------------------------
	
	public int getValue(){
		return storedValue;
	}
	public CH4_IntegerLinkedList getNext(){
		return next;
	}

	public void setValue(int input){
		storedValue = input;
	}
	public void setNext(CH4_IntegerLinkedList input){ //this is also used to delete a node by changing the reference
		next = input;
	}
	
	
	//----------------------------Adding a Node---------------------
	public void addNode(CH4_IntegerLinkedList before,CH4_IntegerLinkedList after){
		before.setNext(this);
		this.setNext(after);
		
	}

	
	

}

