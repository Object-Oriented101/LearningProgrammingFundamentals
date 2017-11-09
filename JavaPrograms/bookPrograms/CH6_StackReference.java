package bookPrograms;

public class CH6_StackReference implements CH6_StackInterface{

	private CH4_Node top;

	public CH6_StackReference(){
		top = null; //head is always null
	}
	
	public boolean isEmpty() {
		if(top == null){
			return true;
		}else return false; 
	}

	public void push(Object input) {
		top = new CH4_Node(input,top); // at this point in time, the top in the parenthesis is still the old top
	}

	public Object pop() {
		if(!isEmpty()){
			CH4_Node temp = top;
			top = top.getNext();
			return temp.getValue();
		}else{
			return "Stack is empty";
		}
	}

	public void popAll() {
			top = null;
	}

	public Object peek() {
		if(!isEmpty()){
			return top.getValue();
		}else{
			return "Stack is empty";
		}
	}
}
