package bookPrograms;

public class CH4_Node {


	private Object storedValue; //the node will store this value
	private CH4_Node next; //the references to the next node
	
	
	//----------------------THE CONSTRUCTORS-----------------------------
	public CH4_Node(Object newItem){ //if only the value is given, invoke this constructor
		storedValue = newItem;
		next = null;
	}
	public CH4_Node(Object newItem, CH4_Node in_object){ //if both are given, put the values in respectively
		storedValue = newItem; //the value this node will hold
		next = in_object;// reference to the next node
	}
	public CH4_Node(CH4_Node in_object){ //if only the value is given, invoke this constructor
		next = in_object;
	}
	
	//-------------------------THE GETTERS AND SETTERS--------------------------
	
	public Object getValue(){
		return storedValue;
	}
	public CH4_Node getNext(){
		return next;
	}

	public void setValue(int input){
		storedValue = input;
	}
	public void setNext(CH4_Node input){ //this is also used to delete a node by changing the reference
		next = input;
	}
	
}

