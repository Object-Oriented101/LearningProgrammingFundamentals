package bookPrograms;

public class CH6_StackArray implements CH6_StackInterface{

	private final int MAX_STACK = 5;
	private Object[] items;
	private int top;

	public CH6_StackArray(){ //constructor for the class
		items = new Object[MAX_STACK];
		top = -1; //why?
	}
	public boolean isEmpty(){
		if(top == -1){
			return true;
		}else return false;
	}
	public boolean isFull(){
		if(top == MAX_STACK-1){ //MAX SIZE -1 one because based on the zero staring number
			return true;
		}else return false;
	}
	public void push(Object newItem) {
		if(!isFull()){
			items[++top] = newItem;
		}else{
			System.out.println("Stack is already full");
		}

	}
	public void popAll() {
		items = new Object[MAX_STACK];
		top = -1;
	}
	public Object pop() {
		if(!isEmpty()){
			return items[top--];
		}else{
			return "Stack is empty";
		}
	}
	public Object peek() {
		if(!isEmpty()){
			return items[top];
		}else{
			return "Stack is empty";
		}
	}
	
	//TESTING METHOD
	public void printStack(){
		for(int i = top; i >= 0; i--){
			System.out.println(items[i]);
		}
	}

}


